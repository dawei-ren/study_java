package com.rendawei.myInternet.testUDP.yudipu;

import org.apache.commons.io.IOUtils;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * Created by bolei on 6/3/17.
 * Simulates Yudipu sensor
 * Loads the raw bytes data from file into cache, if  send_stream flag is set, every UDP package contains
 * a random length byte array otherwise byte array of a randomly picked particle
 */
class SensorSimulator {

  private final SimulationDataGenerator generator;
  private final int targetPort;
  private final long interval;
  private long start;
  private long end;
  private final String srcIP;
  private final String targetIP;

  private SensorSimulator(SimulationDataGenerator generator, int targetPort, long interval, String srcIP, String targetIP) {
    this.generator = generator;
    this.targetPort = targetPort;
    this.interval = interval;
    this.srcIP = srcIP;
    this.targetIP = targetIP;
  }

  private void simulate() {
    int srcPort = 15555;
    Timer timer = new Timer();
    ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

    InetSocketAddress sourceAddr = new InetSocketAddress("localhost", srcPort);
    InetSocketAddress targetAddr = new InetSocketAddress(
        "localhost", targetPort);
    try (DatagramChannel channel = DatagramChannel.open()) {
      channel.bind(sourceAddr);
      start = System.currentTimeMillis();
      service.scheduleAtFixedRate(new Runnable() {
        @Override
        public void run() {
          byte[] data = generator.generateData();
          System.out.println(data.length);
          if (data.length == 0){
            end = System.currentTimeMillis();

            service.shutdown();
            System.out.println("over");
            System.out.println("start time:" + start+ "; end time:" + end+ "; Run Time:" + (end - start) + "(ms)");
            System.out.println(generator.getCount());
            System.out.println("speed: " + getSpeed(generator.getCount(), end-start) + " M/s");
          }
          ByteBuffer buffer = ByteBuffer.wrap(data);
          try {
            channel.send(buffer, targetAddr);
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
      }, 0,10000, TimeUnit.NANOSECONDS);
      Thread.currentThread().join();
    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    } finally {
      System.out.println("simulation done");
    }

  }

  private float getSpeed(long byteCount, long runTime){
    float timeDelta = (float) runTime / 1000;
    float data = (float) byteCount/1024/1024;
    return data / timeDelta;

  }

  public static void main(String[] args) throws Exception {

    long interval = 1L;
    int targetPort = 908;
    String datafile = "C:\\Users\\David\\Desktop\\12yiqi\\2021-01-11-09-36-17.yudipu.raw";
    String sendStream = "stream";
    String sensorIp = "127.0.0.1";
    String sendIp = "127.0.0.1";

    SimulationDataGenerator generator;


    switch (sendStream) {
      case "stream":
        generator = new StreamDataGenerator(datafile, interval);
        break;
      case "one":
        generator = new StreamOneDataGenerator(datafile, 1280);
        break;
      default:
        throw new IllegalStateException("Unexpected value: " + sendStream);
    }

    SensorSimulator simulator = new SensorSimulator(generator, targetPort, interval,sensorIp, sendIp);
    simulator.simulate();
  }

  private interface SimulationDataGenerator {
    byte[] generateData();
    long getCount();
  }


  private static class StreamDataGenerator implements SimulationDataGenerator {

    private final byte[] rawBytes;
    private final long interval;
    int start = 0;

    private StreamDataGenerator(String datafile, long interval) throws IOException {
      System.out.println("StreamDataGenerator: reading from file: " + datafile);
      try (InputStream is = new FileInputStream(datafile)) {
        this.rawBytes = IOUtils.toByteArray(is);
      }
      this.interval = interval;
    }

    @Override
    public byte[] generateData() {
      int len = ThreadLocalRandom.current().nextInt(50, 1280);
      len = Math.min(rawBytes.length - start, len);
      byte[] data = Arrays.copyOfRange(rawBytes, start, start + len);
      if (interval >= 1000) {
        System.out.println("generated data from: " + start + ", to: " + (start + len) + " size: " + data.length);
      }
      start = (start + len) % rawBytes.length;
      return data;
    }

    @Override
    public long getCount() {
      return 0;
    }
  }

  private static class StreamOneDataGenerator implements SimulationDataGenerator {

    private final byte[] rawBytes;
    int start = 0;
    int len;

    private StreamOneDataGenerator(String datafile, int len) throws IOException {
      System.out.println("StreamDataGenerator: reading from file: " + datafile);
      try (InputStream is = new FileInputStream(datafile)) {
        this.rawBytes = IOUtils.toByteArray(is);
      }
      this.len = len;
    }

    @Override
    public byte[] generateData() {
      byte[] data;
      int size = ThreadLocalRandom.current().nextInt(50, len);

      if (start < rawBytes.length-size) {
        data = Arrays.copyOfRange(rawBytes, start, start + size);
        start = start + size;
      } else if (rawBytes.length-size <= start && start < rawBytes.length){
        data = Arrays.copyOfRange(rawBytes, start, rawBytes.length);
        start = start + size;
        System.out.println(start + ": start");
      } else {
        data = new byte[0];
      }

      return data;
    }

    @Override
    public long getCount() {
      return rawBytes.length;
    }
  }

}

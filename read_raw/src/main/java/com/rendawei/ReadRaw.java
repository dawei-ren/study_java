package com.rendawei;

import org.apache.commons.cli.*;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadRaw {

  public static void main(String[] args) throws IOException {
    CommandLineParser parser = new DefaultParser();
    Options options = new Options();
    options.addOption(Option.builder().longOpt("datafile").required().hasArg().build());


    try {
      CommandLine line = parser.parse(options, args);
      String fileName = line.getOptionValue("datafile",null);

      StreamDataGenerator dataGenerator = new StreamDataGenerator(fileName);
      dataGenerator.countData();
    } catch (ParseException e) {
      e.printStackTrace();
      HelpFormatter formatter = new HelpFormatter();
      formatter.printHelp("java", options);
    }


  }
}

class StreamDataGenerator {

  private final byte[] rawBytes;

  int lineArrayCount1 = 0;
  int lineArrayCount2 = 0;

  int lineArrayCount1_meta = 0;
  int lineArrayCount2_meta = 0;

  int meta = 0;

  StreamDataGenerator(String datafile) throws IOException {
    System.out.println("StreamDataGenerator: reading from file: " + datafile);
    try (InputStream is = new FileInputStream(datafile)) {
      this.rawBytes = IOUtils.toByteArray(is);
    }
  }

  public void countData() {
    for (int i = 0; i < rawBytes.length; i++) {
      if (rawBytes[i]==(byte) 0x55
          && rawBytes[i+1]==(byte) 0xaa){
        meta++;
        i = i + 14;
      }
    }
    for (int i = 0; i < rawBytes.length; i++) {
      if (rawBytes[i]==(byte) 0x55
          && rawBytes[i+1]==(byte) 0xaa
          && rawBytes[i+2]==(byte) 0x11
          && rawBytes[i+3]==(byte) 0x11){
        lineArrayCount1++;
        i = i + 14;
      } else if (rawBytes[i]==(byte) 0x55
          && rawBytes[i+1]==(byte) 0xaa
          && rawBytes[i+2]==(byte) 0x22
          && rawBytes[i+3]==(byte) 0x22){
        lineArrayCount2++;
        i = i+14;
      }
    }

    for (int i = 0; i < rawBytes.length; i++) {
      if (rawBytes[i]==(byte) 0x55
          && rawBytes[i+1]==(byte) 0xaa
          && rawBytes[i+2]==(byte) 0x11
          && rawBytes[i+3]==(byte) 0x11){
        lineArrayCount1_meta++;
      } else if (rawBytes[i]==(byte) 0x55
          && rawBytes[i+1]==(byte) 0xaa
          && rawBytes[i+2]==(byte) 0x22
          && rawBytes[i+3]==(byte) 0x22){
        lineArrayCount2_meta++; 
      }
    }

    System.out.println("55 aa 11 11 :" + lineArrayCount1);
    System.out.println("55 aa 22 22 :" + lineArrayCount2);

    System.out.println("55 aa 11 11 -meta :" + lineArrayCount1_meta);
    System.out.println("55 aa 22 22 -meta :" + lineArrayCount2_meta);

    System.out.println("55 aa :" + meta);


  }
}
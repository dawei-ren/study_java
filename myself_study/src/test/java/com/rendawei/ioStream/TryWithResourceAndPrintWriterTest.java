package com.rendawei.ioStream;

import com.rendawei.ioStream.TryWithResourceAndPrintWriter;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class TryWithResourceAndPrintWriterTest {
    TryWithResourceAndPrintWriter twrapw;

    @Before
    public void setUp() throws IOException {
        this.twrapw = new TryWithResourceAndPrintWriter("testFileDirectory");
    }

    @Test
    public void testWriteFile(){
        twrapw.writeFile("Hello word", "test.txt");
    }

    @Test
    public void testReadFile(){
        twrapw.readFile();
    }

}
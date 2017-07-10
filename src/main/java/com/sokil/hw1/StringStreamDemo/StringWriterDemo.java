package com.sokil.hw1.StringStreamDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StringWriterDemo {
    public  void readAndWrite(String fromFile, String toFile) throws IOException {
        FileInputStream fis = new FileInputStream(new File(fromFile));
        FileOutputStream fos = new FileOutputStream(new File(toFile));
        byte[] buffer = new byte[512];
        int rc;

        while((rc = fis.read(buffer)) != -1) {
            fos.write(buffer, 0, rc);
        }

        fos.close();
        fis.close();
    }
}

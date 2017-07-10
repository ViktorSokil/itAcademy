package com.sokil.hw1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class RandomFile {

    public void createAndWriteFile(String path, int byt)  {
        Random generator = new Random();
        File file = new File(path, "hello.txt");
        try {
            if (file.createNewFile() == true){
                StringBuilder path2 = new StringBuilder();
                path2.append(path).append("//hello.txt");
                String path3 = path2.toString();
                RandomInputStream inputStream = new RandomInputStream();
                byte[] buffer = inputStream.read(byt);
                writeRandomBytes(path3, buffer);
            }
            else{
                System.out.println("File doesn't create");
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

        private void writeRandomBytes(String path, byte[] buffer){
        try(FileOutputStream fos=new FileOutputStream(path))
        {
            fos.write(buffer, 0, buffer.length);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}

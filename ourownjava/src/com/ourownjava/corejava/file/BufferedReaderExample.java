package com.ourownjava.corejava.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
 
/**
 * 
 * @author ourownjava.com
 *
 */
 
public class BufferedReaderExample {
 
    private void readLine(File file) throws IOException{
        if(null != file){
            BufferedReader reader = null;
            FileReader fileReader = null;
            try {
                String line;
                fileReader = new FileReader(file);
                reader = new BufferedReader(fileReader, 256);
                while( (line = reader.readLine()) != null ){
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
                throw new IOException(e.getMessage());
            }finally{
                if(fileReader != null){
                    fileReader.close();
                }
                if(reader != null ){
                    reader.close();
                }
            }
        }else{
            throw new IllegalArgumentException("File reference is null");
        }
    }
    
    public static void main(String args[]) throws IOException{
        new BufferedReaderExample().readLine(new File("/mnt/java/sample.file"));
    }
}
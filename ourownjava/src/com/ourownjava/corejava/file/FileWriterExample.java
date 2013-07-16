package com.ourownjava.corejava.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * 
 * @author ourownjava.com
 *
 */
public class FileWriterExample {
	
	public static void main(String[] args) throws IOException {
		   FileWriterExample fileWriter = new FileWriterExample();
	        fileWriter.write();
	        fileWriter.writeThruBuffer();
	}
	
	private void write() throws IOException{
        Writer fileWriter = null;
        try {
            long startTime = System.currentTimeMillis();
            fileWriter = new FileWriter(new File("FileWriterExample.dat"));
            for(int i=1000000; i>0; i--){
                fileWriter.write(i+" ,");
            }
            System.out.println("Time Taken with out buffer : "+
                    (System.currentTimeMillis() - startTime));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            if(null != fileWriter){
                fileWriter.close();
            }
        }
    }
     
    private void writeThruBuffer() throws IOException{
        Writer fileWriter = null;
        try {
            long startTime = System.currentTimeMillis();
            fileWriter = new BufferedWriter(new FileWriter(new
                    File("BufferedFileWriterExample.dat")));
             
            for(int i=1000000; i>0; i--){
                fileWriter.write(i+" ,");
            }
            System.out.println("Time Taken with buffer : "+
                    (System.currentTimeMillis() - startTime));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            if(null != fileWriter){
                fileWriter.close();
            }
        }
    }

}

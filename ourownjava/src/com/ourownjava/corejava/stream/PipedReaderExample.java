package com.ourownjava.corejava.stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedReader;
import java.io.PipedWriter;
/**
 * @date 1st May, 2011
 * @author ourownjava.com
 *
 * To demonstrate the use of piped character streams.
 * Example program for piped character stream in java.
 *
 */

public class PipedReaderExample {

	public static void main(String args[]) throws IOException{
		final PipedReader reader = new PipedReader();
		final PipedWriter writer = new PipedWriter(reader);
		final Thread readerThread = new Thread(new ReaderThread(writer));
		final Thread writerThread = new Thread(new WriterThread(reader));
		readerThread.start();
		writerThread.start();
	}

}

class ReaderThread implements Runnable{
	PipedWriter writer;
	public ReaderThread(PipedWriter writer){
		this.writer = writer;
	}

	public void run() {
		final InputStreamReader streamReader = new InputStreamReader(System.in);
		final BufferedReader bufferedReader = new BufferedReader(streamReader);
		try {
			while (true) {
				//sample implementation reading from console
				//real implementation can be reading from a socket or a file
				//or from server side code
				String line = bufferedReader.readLine();
				writer.write(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class WriterThread implements Runnable{
	PipedReader reader;
	public WriterThread(PipedReader reader){
		this.reader = reader;
	}

	public void run() {
		while(true){
			try {
				char c;
				while( (c = (char)reader.read()) != -1){
					//write your business logic here
					//could be writing into a file
					//could be processing the date
					System.out.print(c);
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
 
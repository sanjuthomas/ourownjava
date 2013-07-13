package com.ourownjava.mongo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSInputFile;

/**
 * @author ourownjava.com
 */
public class MongoDBSaveBinaryFile {

	private static final String HOST = "localhost";

	private static final int PORT = 27017;
	
	private static final String DB_NAME = "reports";
	
	private static final String BUCKET_NAME = "pdfFiles";

	/**
	 * Create a mongodb connection
	 * 
	 * @return Mongo Connection
	 * @throws UnknownHostException
	 */
	public Mongo getConnection() throws UnknownHostException {
		return new Mongo(HOST, PORT);
	}
	
	/**
	 * save a binary file into mongodb 
	 * @throws IOException 
	 */
	private void saveFile(final DB db, final File file) throws IOException{
		final GridFS gridFs = new GridFS(db);
		final GridFSInputFile gridFSInputFile = gridFs.createFile(file);
		gridFSInputFile.setFilename(file.getName());
		gridFSInputFile.save();
	}
	
	/**
	 * save a binary file into a specific bucket in mongdb
	 * @throws FileNotFoundException 
	 */
	private void saveFile(final DB db, final String bucketName, final File file) throws FileNotFoundException{
		new GridFS(db, bucketName).createFile(new FileInputStream(file), file.getName()).save();
	}
	
	/**
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		final MongoDBSaveBinaryFile dbSaveBinaryFile = new MongoDBSaveBinaryFile();
		//get a mongodb connection
		final Mongo mongoConnection = dbSaveBinaryFile.getConnection();
		//get the database from the connection
		final DB database = mongoConnection.getDB(DB_NAME);
		//save the file into default bucket called fs
		final File binaryFile = new File("/home/thosan/java/testfiles/test.pdf");
		dbSaveBinaryFile.saveFile(database, binaryFile);
		//save the binary file into pdfFiles bucket
		dbSaveBinaryFile.saveFile(database, BUCKET_NAME, binaryFile);
	}
}

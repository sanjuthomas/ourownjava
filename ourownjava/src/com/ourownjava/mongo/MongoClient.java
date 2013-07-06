package com.ourownjava.mongo;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.WriteResult;

/**
 * Insert element into array - mongodb
 * 
 * @author ourownjava.com
 */
public class MongoClient {

	private static final String HOST = "localhost";

	private static final int PORT = 27017;

	/**
	 * @return Mongo
	 * @throws UnknownHostException
	 */
	public static Mongo getConnection() throws UnknownHostException {
		return new Mongo(HOST, PORT);
	}

	/**
	 * @param dbName
	 * @param collectionName
	 * @return
	 * @throws UnknownHostException
	 */
	private static DBCollection getCollection(final String dbName,
			final String collectionName) throws UnknownHostException {
		Mongo mongo = getConnection();
		DB db = mongo.getDB(dbName);
		return db.getCollection(collectionName);
	}

	/**
	 * @param args
	 * @throws UnknownHostException
	 */
	public static void main(final String[] args) throws UnknownHostException {

		WriteResult result = addComment(new BasicDBObject("_id", 1), "Amit",
				"We should take legal actions");
		if (null == result.getError()) {
			System.out.println("Comment is Successfully added");
		}
	}

	private static WriteResult addComment(final BasicDBObject incidentObject,
			final String author, final String comment)
			throws UnknownHostException {
		final BasicDBObject commentObject = new BasicDBObject();
		commentObject.put("author", author);
		commentObject.put("comment", comment);

		final DBCollection incidentsCollection = getCollection("incidentLog",
				"incidents");
		return incidentsCollection.update(incidentObject, new BasicDBObject(
				"$push", new BasicDBObject("comments", commentObject)), false,
				false);
	}

}
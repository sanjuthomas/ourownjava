package com.ourownjava.mongo;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;

/**
 * @author ourownjava.com
 */

public class MongoDBOrderByExample {

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
	 * @param args
	 * @throws UnknownHostException
	 */
	public static void main(final String[] args) throws UnknownHostException {
		final Mongo mongo = getConnection();
		final DB db = mongo.getDB("cricket");
		final DBCollection collections = db.getCollection("batsman");

		final BasicDBObject searchQuery = new BasicDBObject();
		final DBCursor cursor = collections.find(searchQuery);

		final BasicDBObject orderBy = new BasicDBObject();
		orderBy.put("Total Score", 1);
		cursor.sort(orderBy);
		printCursor(cursor);
	}

	private static void printCursor(final DBCursor cursor) {
		while (cursor.hasNext()) {
			System.out.println("");
			final DBObject dbObject = cursor.next();
			for (final String key : dbObject.keySet()) {
				System.out.print(key);
				System.out.print(" >> ");
				System.out.print(dbObject.get(key));
			}
		}
	}

}
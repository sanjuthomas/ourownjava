package com.ourownjava.corejava.exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ourownjava.com
 *
 * Handling multiple exception in one catch block.
 *
 */

public class MultiExceptionHandingInOneCatchBlock {

	public static void main(String args[]){
		new MultiExceptionHandingInOneCatchBlock().catchMany();
	}
	@SuppressWarnings({"unused", "resource"})
	public void catchMany()
	{
		try{
			final FileInputStream inputStream = new FileInputStream(new File("test.txt"));
			final Connection connection = DriverManager.getConnection("none");
		}catch(SQLException | IOException e){
			e.printStackTrace();
		}
	}

}
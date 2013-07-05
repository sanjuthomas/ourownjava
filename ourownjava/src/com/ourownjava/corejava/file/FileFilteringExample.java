package com.ourownjava.corejava.file;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ourownjava.com
 * @date 31st July, 2011
 * 
 * How to filter file in java? 
 * FileFilter example in java.
 * 
 */

public class FileFilteringExample {
	public static void main(final String args[]) {
		final FileExtensionFilter filter = new FileExtensionFilter(".java");
		final List<File> javaFiles = new ArrayList<File>();
		new FileFilteringExample().findUsingExtension(new File("/local/opt"),
				filter, javaFiles);
		System.out.println("Found " + javaFiles.size()
				+ " java files in /local/opt");
		for (final File file : javaFiles) {
			System.out.println(file.getAbsolutePath());
		}
	}

	private void findUsingExtension(final File file, final FileFilter filter, final List<File> files) {
		if (file.isDirectory()) {
			final File[] filteredFiles = file.listFiles(filter);
			if (null != filteredFiles) {
				files.addAll(Arrays.asList(filteredFiles));
			}
			for (final File childFile : file.listFiles()) {
				if (null != childFile) {
					findUsingExtension(childFile, filter, files);
				}
			}
		}
	}

}
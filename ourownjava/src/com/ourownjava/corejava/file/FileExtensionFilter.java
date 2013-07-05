package com.ourownjava.corejava.file;

import java.io.File;
import java.io.FileFilter;

/**
 * @author ourownjava.com
 * @date 31st July, 2011
 * 
 * How to filter file in java? 
 * FileFilter example in java.
 * 
 */

public class FileExtensionFilter implements FileFilter {
	private String extension;

	public FileExtensionFilter(final String extension) {
		this.extension = extension;
	}

	public boolean accept(final File pathname) {
		boolean accept = false;
		if (null != pathname) {
			accept = pathname.getAbsolutePath().endsWith(extension);
		}
		return accept;
	}
}
package com.ourownjava.corejava.file;

import java.io.File;
import java.io.FileFilter;

import org.apache.commons.io.filefilter.WildcardFileFilter;

/**
 * 
 * @author ourownjava.com
 *
 */

public class FileWildcardFilter {

    private static File[] loadFiles(String location, String fileName) {

        final File dir = new File(location);
        final FileFilter fileFilter = new WildcardFileFilter(fileName);
        return dir.listFiles(fileFilter);
    }

    public static void main(String args[]) throws Exception {
        final File[] files = loadFiles("\tmp", "08-12-11_*feed*.dat");
        for (File file : files) {
            System.out.println(file.getName());
        }
    }

}
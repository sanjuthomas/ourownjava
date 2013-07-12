package com.ourownjava.corejava.file;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
 
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
 
/**
 *
 * @author sanju.org
 * @date August 17th, 2011
 *
 * Reloading property file without restarting the JVM
 *
 */
public class ResourceLoadingExample {
 
    public static void main(String args[]) throws ConfigurationException,
        InterruptedException{
 
        PropertiesConfiguration property = new PropertiesConfiguration
                ("application.properties");
        property.setReloadingStrategy(new FileChangedReloadingStrategy());
        Thread thread = new PropertyFileChangerThread("application.properties");
        thread.start();
 
        while(true){
            Iterator i = property.getKeys();
            while(i.hasNext()){
                System.out.println(i.next());
            }
            Thread.sleep(1000);
        }
    }
}
 
class PropertyFileChangerThread extends Thread{
 
    private String fileName;
 
    PropertyFileChangerThread(String fileName){
        this.fileName = fileName;
    }
 
    public void run(){
        try {
            while(true){
                FileWriter fileWriter = new FileWriter(fileName, true);
                fileWriter.write("\n");
                fileWriter.write(Math.random()+"="+Math.random());
                fileWriter.flush();
                Thread.sleep(5000);
                fileWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
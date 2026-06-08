package unilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {


    //creating the object of Properties class
    //We need Properties class to use methods of that class ->getProperty("key"), load()
    private static Properties properties = new Properties(); // we made that object static, because we will use it (line24) in static block, and use it (line 37)  in static method, and static method can not accept non-static fields/ We also make it private in order we do not want that other classes use that object, only that class

    static {// we use extra curly braces in order to avoid complaining because try and catch block must be inside any block, and we make that block static in order to open and read .properties file before actual using custom getProperty() method from that class ->so properties file and load() will run (opens) once before reading

        try {
            // creating the object of FileInputStream
            //We need that object to open file as a stream in Java memory

            FileInputStream file = new FileInputStream("configuration.properties"); // need provide pathway of file in argument// go to .properties file, lest click - copyPath-> path from content Root

            //load properties object using file FileInputStream object
            // load "properties" object with the "file" we opened using FileInputStream
            properties.load(file);
            file.close(); // after file were loaded and read once when custom method getProperty called, we will close file to keep memory clean
        } catch (IOException e) {
            e.printStackTrace();

        }
    }// we use extra curly braces in order to avoid complaining because try and catch block must be inside any block


    // now we ready to create our custom getProperty method, which help us avoid to repeat lot of code in order to provide any value from .properties file to our code
    // basically we coverd build in method getProperty() by our custom method getProperty(String keyword){}
    public static String getProperty(String keyword) {

        return properties.getProperty(keyword);
    }

}

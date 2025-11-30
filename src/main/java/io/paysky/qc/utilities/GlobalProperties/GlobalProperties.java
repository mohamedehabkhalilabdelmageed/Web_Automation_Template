package io.paysky.qc.utilities.GlobalProperties;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GlobalProperties {
    /***
     * This class is responsible for getting the properties file at resources folder
     * **/
    static String propFileName = "config.properties";
    public static Properties global_propertoes =  new Properties();
    public static String getProperty(String name) throws IOException {
        InputStream input = new FileInputStream("./src/main/resources/" + propFileName);
        GlobalProperties.global_propertoes.load(input);
        return global_propertoes.getProperty(name);}
}

package com.Pg4.Pg.Util;

import org.openqa.selenium.NotFoundException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropsReader {

    public static String FilePath;

    public static String configfilepath = "./src/test/resources/Config/";
    public static String driver;

    public static String Patient_Email;
    public static String Patient_Password;

    public static String Practitioner_Email;

    public static String Practitioner_Password;
    public static int Timeout;

    public static String BaseUrl;

    public PropsReader(){
        super();

        PropsReader.driver = readPropertiesFile(configfilepath +"BaseConfig.properties").getProperty("Driver");
        PropsReader.BaseUrl=readPropertiesFile(getBaseConfig()).getProperty("BaseUrl");
        PropsReader.Patient_Email =readPropertiesFile(getBaseConfig()).getProperty("Patient_Email");
        PropsReader.Patient_Password =readPropertiesFile(getBaseConfig()).getProperty("Patient_Password");
        PropsReader.Practitioner_Email = readPropertiesFile(getBaseConfig()).getProperty("Practitioner_Email");
        PropsReader.Practitioner_Password = readPropertiesFile(getBaseConfig()).getProperty("Practitioner_Password");
        PropsReader.Timeout = Integer.parseInt(readPropertiesFile(getBaseConfig()).getProperty("Timeout_in_Seconds"));



    }

    public static Properties readPropertiesFile(String Filename){

        FileInputStream fis = null;
        Properties prop = null;
        try {
            fis = new FileInputStream(Filename);
            prop = new Properties();
            prop.load(fis);
        } catch (IOException fnfe) {
            fnfe.printStackTrace();
        } finally {
            try {
                assert fis != null;
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return prop;

    }

    public String getBaseConfig(){

        String Envi = readPropertiesFile(configfilepath + "BaseConfig.properties").getProperty("Environment");
        Properties prop = new Properties();
        try{
            prop.load(PropsReader.class.getClassLoader().getResourceAsStream("Project.properties"));

        }catch (IOException e){
            e.printStackTrace();
        }

        String Env = prop.getProperty("Environment");
        if(Envi.equals("$Environment")){

            Envi = Env;

        }

        try {

            switch (Envi.toLowerCase()) {


                case "testing":
                    FilePath = configfilepath + "Testing/testing.Properties";
                    break;

                default:
                    throw new NotFoundException("Not found");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return FilePath;

    }

}

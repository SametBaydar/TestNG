package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    static Properties properties;

    static {
        String dosyoYolu = "configuration.properties";
        try {
            FileInputStream fis = new FileInputStream(dosyoYolu);
            properties = new Properties();
            properties.load(fis);
        }catch (IOException e){
            System.out.println("properties dosyası okunamadı.");
        }
    }
    public static String getProperty(String key){
        return properties.getProperty(key);
    }


}

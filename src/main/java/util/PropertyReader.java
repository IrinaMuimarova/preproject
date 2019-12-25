package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    public static final String PATH_TO_PROPERTIES = "C:\\preproject\\src\\main\\resources\\config.properties";

    public static Properties readProperty() {
        Properties prop = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(PATH_TO_PROPERTIES)) {
            prop.load(fileInputStream);
            return prop;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

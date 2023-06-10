import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConfigFileReader {
    public Properties readConfigFile(String filePath) throws IOException {
        Properties properties = new Properties();

        try (FileInputStream fis = new FileInputStream(filePath)) {
            properties.load(fis);
        }
        return properties;
    }
}

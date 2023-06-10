import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    public Properties readConfigFile(String filePath) throws IOException {
        Properties properties = new Properties();

        try (FileInputStream fis = new FileInputStream(filePath)) {
            properties.load(fis);
        }
        return properties;
    }
}

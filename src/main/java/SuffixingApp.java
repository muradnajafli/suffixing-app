import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class SuffixingApp {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java SuffixingApp <config-file-path>");
            return;
        }

        String configFilePath = args[0];

        ConfigFileReader configFileReader = new ConfigFileReader();
        FileProcessor fileProcessor = new FileProcessor();

        try {
            Properties config = configFileReader.readConfigFile(configFilePath);
            String mode = config.getProperty("mode");
            String suffix = config.getProperty("suffix");
            String filesString = config.getProperty("files");

            LoggerUtil.logMissingMode(mode);

            if (suffix == null || suffix.isEmpty()) {
                LoggerUtil.logMissingSuffix();
                return;
            }

            if (filesString == null || filesString.isEmpty()) {
                LoggerUtil.logMissingFiles();
                return;
            }

            List<String> files = Arrays.asList(filesString.split(":"));

            fileProcessor.processFiles(files, mode, suffix);
        } catch (IOException e) {
            LoggerUtil.logSevere("Failed to read config file: " + configFilePath);
        }

    }

}

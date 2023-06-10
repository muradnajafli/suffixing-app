import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerUtil {
    private static final Logger logger = Logger.getLogger(LoggerUtil.class.getName());

    static {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);

        logger.addHandler(consoleHandler);
        logger.setLevel(Level.ALL);
    }

    public static void logSevere(String message) {
        logger.log(Level.SEVERE, message);
    }

    public static void logWarning(String message) {
        logger.log(Level.WARNING, message);
    }

    public static void logInfo(String message) {
        logger.log(Level.INFO, message);
    }

    public static void logMissingMode(String mode) {
        logSevere("Mode is not recognized: " + mode);
    }

    public static void logMissingSuffix() {
        logSevere("No suffix is configured");
    }

    public static void logMissingFiles() {
        logWarning("No files are configured to be copied/moved");
    }

    public static void logNoSuchFile(String filepath) {
        logSevere("No such file: " + filepath.replace('\\','/'));
    }

    public static void logMoveFile(String sourceFile, String destinationFile) {
        logInfo(sourceFile.replace('\\', '/') + " => " + destinationFile.replace('\\', '/'));
    }

    public static void logCopyFile(String sourceFile, String destinationFile) {
        logInfo(sourceFile.replace('\\', '/') + " -> " + destinationFile.replace('\\', '/'));
    }


    public static void logCopyFile(String sourceFile1, String destinationFile1,
                                   String sourceFile2, String destinationFile2) {
        logInfo(sourceFile1.replace('\\', '/') + " -> " + destinationFile1.replace('\\', '/'));
        logInfo(sourceFile2.replace('\\', '/') + " -> " + destinationFile2.replace('\\', '/'));
    }
    }




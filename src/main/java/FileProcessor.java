import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;


public class FileProcessor {
    public void processFiles(List<String> files, String mode, String suffix) {
        for (String filePath : files) {
            Path sourcePath = Path.of(filePath);

            if (!Files.exists(sourcePath)) {
                LoggerUtil.logSevere("No such file: " + filePath.replace('\\', '/'));
                continue;
            }

            String fileName = sourcePath.getFileName().toString();
            String newName = getNewName(fileName, suffix);
            Path destinationPath = sourcePath.resolveSibling(newName);

            try {
                if (mode.equalsIgnoreCase("copy")) {
                    Files.copy(sourcePath, destinationPath, StandardCopyOption.COPY_ATTRIBUTES);
                    LoggerUtil.logCopyFile(sourcePath.toString(), destinationPath.toString());
                } else if (mode.equalsIgnoreCase("move")) {
                    Files.move(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
                    LoggerUtil.logMoveFile(sourcePath.toString(), destinationPath.toString());
                }
            } catch (IOException e) {
                LoggerUtil.logSevere("Failed to process file: " + filePath.replace('\\', '/'));
            }
        }
    }

    private String getNewName(String fileName, String suffix) {
        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex == -1) {
            return fileName + suffix;
        } else {
            String nameWithoutExtension = fileName.substring(0, dotIndex);
            String extension = fileName.substring(dotIndex);
            return nameWithoutExtension + suffix + extension;
        }
    }
}
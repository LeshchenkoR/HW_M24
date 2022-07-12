package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

public class CreateFileUtil {
    private static final Logger logger = Logger.getLogger(CreateFileUtil.class.getName());

    public static File createNewFile(String directory, String extension) throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String date = formatter.format(LocalDateTime.now());

        Path newDirectoryPath = Paths.get(directory);

        if (!Files.exists(newDirectoryPath)) {
            try {
                Files.createDirectory(newDirectoryPath);
                logger.info("Directory created");
            } catch (IOException e) {
                logger.info("Directory already exist");
            }
        }
        Path newFilePath = Paths.get(newDirectoryPath + File.separator + date + extension);

        if (!Files.exists(newFilePath)) {
            try {
                Files.createFile(newFilePath);
                logger.info("File created");
            } catch (IOException e) {
                logger.info("file already exist");
            }
        }
        return newFilePath.toFile();
    }
}
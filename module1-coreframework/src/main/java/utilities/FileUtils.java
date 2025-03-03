package utilities;

import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

public class FileUtils {
    public static final String FILE_PATH = "src/test/java/outputfiles/";
    private static final Logger logger = Logger.getLogger(FileUtils.class.getName());
    private static File file;
    private static String filePath;

    public FileUtils createFile(String fileNamePrefix) throws IOException {


        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = fileNamePrefix + "_" + timestamp + ".txt"; // Append timestamp to filename
        createDirectory(FILE_PATH);

        file = new File(FILE_PATH + fileName);



        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + filePath);
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            throw new IOException("Failed while creating file" +e);
        }
        filePath = file.getAbsolutePath();

        return this;
    }

    public FileUtils writeIntoFile(String statement1, String statement2){
        try {
            FileWriter writer = new FileWriter(file.getAbsolutePath(), true);
            // true = append mode
            writer.write(statement1 + " --> " + statement2 + "\n");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return this;
    }

    public FileUtils writeIntoFile(String statement){
        try {
            FileWriter writer = new FileWriter(file.getAbsolutePath(), true);
            // true = append mode
            writer.write(statement + "\n");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return this;
    }

    public String getFilePath() {
        return filePath;
    }

    public void createDirectory(String directoryName) {
        File directory = new File(FILE_PATH + directoryName);
        if (!directory.exists()) {
            if (directory.mkdir()) {
                System.out.println("Directory created: " + directory.getAbsolutePath());
            } else {
                System.out.println("Failed to create directory.");
            }
        }
    }


}

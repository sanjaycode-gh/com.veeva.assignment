package utilities;

import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileUtils {
    public static final String FILE_PATH = "src/test/java/";
    static File file;

    public FileUtils createFile(String fileName){

        file = new File(FILE_PATH + fileName);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("Old file deleted successfully.");
            } else {
                System.out.println("Failed to delete old file.");
            }
        }

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


}

package misc;

import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {

    public void writeFile(String content, String fileName){
        try {
            // Create a FileWriter object with the specified file name
            FileWriter writer = new FileWriter(fileName);

            // Write the content to the file
            writer.write(content);

            // Close the writer to release resources
            writer.close();

            System.out.println("Content has been written to the file.");
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

}

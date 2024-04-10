package mainpkg;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CybersecurityManager {
    private List<String> files;

    public CybersecurityManager() {
        // Initialize files list
        files = new ArrayList<>();
    }

    // Method to upload a file to the system
    public void uploadFile(String fileName, String content) throws IOException {
        // Write content to the file
        FileWriter writer = new FileWriter(fileName);
        writer.write(content);
        writer.close();
        files.add(fileName);
    }

    // Method to read the content of a file
    public String readFile(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    // Method to update the content of a file
    public void updateFile(String fileName, String newContent) throws IOException {
        // Write new content to the file
        FileWriter writer = new FileWriter(fileName);
        writer.write(newContent);
        writer.close();
    }

    // Method to delete a file
    public void deleteFile(String fileName) throws IOException {
        // Delete the file from the system
        File file = new File(fileName);
        if (file.exists()) {
            file.delete();
            files.remove(fileName);
        }
    }

    // Method to get the list of files
    public List<String> getFiles() {
        return files;
    }
}

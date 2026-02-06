package encryption.decryption;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {

    /**
     * Reads the entire contents of a file into a String.
     */
    public String readFile(String filename) throws IOException {
        StringBuilder content = new StringBuilder();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        
        removeTrailingNewline(content);
        return content.toString();
    }
    
    /**
     * Writes the given content to a file.
     * Overwrites the file if it already exists.
     */
    public void writeFile(String filename, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
        }
    }
 
     
    /**
     * Removes the final newline character from the content
     * to prevent an extra blank line at the end of the file.
     */
    private void removeTrailingNewline(StringBuilder content) {
        if (content.length() > 0) {
            content.setLength(content.length() - 1);
        }
    }
}

package encryption.decryption;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {

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
    

    public void writeFile(String filename, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
        }
    }
 
    private void removeTrailingNewline(StringBuilder content) {
        if (content.length() > 0) {
            content.setLength(content.length() - 1);
        }
    }
}

package encryption.decryption;

import java.io.File;

public class InputValidator {

    public boolean isValidMode(String input) {
        return input != null && (input.equals("E") || input.equals("D"));
    }
    
   
    public boolean isValidMethod(String input) {
        return input != null && (input.equals("S") || input.equals("T"));
    }
    
  
    public boolean isValidKey(String key) {
        return key != null && !key.isEmpty();
    }
    
    public boolean isValidFilename(String filename) {
        if (filename == null || filename.isEmpty()) {
            return false;
        }
        File file = new File(filename);
        return file.exists() && file.isFile();
    }
}

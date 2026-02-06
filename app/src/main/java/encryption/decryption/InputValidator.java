package encryption.decryption;

import java.io.File;

public class InputValidator {

    /**
     * Validates the selected mode.
     *
     * Acceptable values:
     * - "E" for Encrypt
     * - "D" for Decrypt
     */
    public boolean isValidMode(String input) {
        return input != null && (input.equals("E") || input.equals("D"));
    }
    
    /**
     * Validates the selected cipher method.
     *
     * Acceptable values:
     * - "S" for Substitution cipher
     * - "T" for Transposition cipher
     */
    public boolean isValidMethod(String input) {
        return input != null && (input.equals("S") || input.equals("T"));
    }
    
    /**
     * Validates the encryption/decryption key.
     * The key must not be null or empty.
     */
    public boolean isValidKey(String key) {
        return key != null && !key.isEmpty();
    }
    
    /**
     * Validates that the provided filename exists and is a file.
     */
    public boolean isValidFilename(String filename) {
        if (filename == null || filename.isEmpty()) {
            return false;
        }
        File file = new File(filename);
        return file.exists() && file.isFile();
    }
}

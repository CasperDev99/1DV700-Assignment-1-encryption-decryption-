package encryption.decryption;

public class FilenameGenerator {
    private String inputFilename;
    private EncryptionMode mode;
    
    /**
     * Constructor initializes filename and encryption mode.
     */
    public FilenameGenerator(String inputFilename, EncryptionMode mode) {
        this.inputFilename = inputFilename;
        this.mode = mode;
    }
    
    /**
     * Generates the new filename based on whether
     * the original filename contains an extension.
     */
    public String generate() {
        if (hasExtension()) {
            return generateWithExtension();
        } else {
            return generateWithoutExtension();
        }
    }
    
    /**
     * Checks if the filename contains a file extension.
     */
    private boolean hasExtension() {
        return inputFilename.lastIndexOf('.') > 0;
    }
    
    /**
     * Generates a new filename while preserving the original extension.
     */
    private String generateWithExtension() {
        int dotIndex = inputFilename.lastIndexOf('.');
        String nameWithoutExtension = inputFilename.substring(0, dotIndex);
        String extension = inputFilename.substring(dotIndex);
        String suffix = getSuffix();
        
        return nameWithoutExtension + suffix + extension;
    }
    
    /**
     * Generates a new filename when no extension exists.
     */
    private String generateWithoutExtension() {
        String suffix = getSuffix();
        return inputFilename + suffix;
    }
    
    /**
     * Determines the suffix based on encryption mode.
     */
    private String getSuffix() {
        return mode == EncryptionMode.ENCRYPT ? "_enc" : "_dec";
    }
}

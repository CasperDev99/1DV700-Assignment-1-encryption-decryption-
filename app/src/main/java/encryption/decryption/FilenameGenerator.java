package encryption.decryption;

public class FilenameGenerator {
    private String inputFilename;
    private EncryptionMode mode;
    
    public FilenameGenerator(String inputFilename, EncryptionMode mode) {
        this.inputFilename = inputFilename;
        this.mode = mode;
    }
    
    public String generate() {
        if (hasExtension()) {
            return generateWithExtension();
        } else {
            return generateWithoutExtension();
        }
    }
    
    private boolean hasExtension() {
        return inputFilename.lastIndexOf('.') > 0;
    }
    
    private String generateWithExtension() {
        int dotIndex = inputFilename.lastIndexOf('.');
        String nameWithoutExtension = inputFilename.substring(0, dotIndex);
        String extension = inputFilename.substring(dotIndex);
        String suffix = getSuffix();
        
        return nameWithoutExtension + suffix + extension;
    }
    
    private String generateWithoutExtension() {
        String suffix = getSuffix();
        return inputFilename + suffix;
    }
    
    private String getSuffix() {
        return mode == EncryptionMode.ENCRYPT ? "_enc" : "_dec";
    }
}

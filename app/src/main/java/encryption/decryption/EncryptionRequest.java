package encryption.decryption;

public class EncryptionRequest {
    private EncryptionMode mode;
    private EncryptionMethod method;
    private String key;
    private String filename;
    
    public EncryptionRequest(EncryptionMode mode, EncryptionMethod method, String key, String filename) {
        this.mode = mode;
        this.method = method;
        this.key = key;
        this.filename = filename;
    }
    
    public EncryptionMode getMode() {
        return mode;
    }
    
    public EncryptionMethod getMethod() {
        return method;
    }
    
    public String getKey() {
        return key;
    }
    
    public String getFilename() {
        return filename;
    }
}

package encryption.decryption;

public enum EncryptionMode {
    ENCRYPT("E"),
    DECRYPT("D");
    
    private String code;
    
    EncryptionMode(String code) {
        this.code = code;
    }
    
    public static EncryptionMode fromString(String value) {
        if (value.equals("E")) {
            return ENCRYPT;
        } else if (value.equals("D")) {
            return DECRYPT;
        }
        throw new IllegalArgumentException("Invalid encryption mode: " + value);
    }

    public String getCode() {
        return code;
    }
}

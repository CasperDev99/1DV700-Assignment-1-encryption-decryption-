package encryption.decryption;

public enum  EncryptionMethod {
    SUBSTITUTION("S"),
    TRANSPOSITION("T");
    
    private String code;
    
    EncryptionMethod(String code) {
        this.code = code;
    }
    
    public static EncryptionMethod fromString(String value) {
        if (value.equals("S")) {
            return SUBSTITUTION;
        } else if (value.equals("T")) {
            return TRANSPOSITION;
        }
        throw new IllegalArgumentException("Invalid encryption method: " + value);
    }
    
    public String getCode() {
        return code;
    }
}

package encryption.decryption;

public class TranspositionCipher implements Cipher {
    
    private KeyConverter keyConverter;
    private RailFenceEncryptor railFenceEncryptor;
    private RailFenceDecryptor railFenceDecryptor;

    /**
     * Constructor initializes helper classes used for
     * key conversion and Rail Fence operations.
     */
    public TranspositionCipher() {
        this.keyConverter = new KeyConverter();
        this.railFenceEncryptor = new RailFenceEncryptor();
        this.railFenceDecryptor = new RailFenceDecryptor();
    }
    
    /**
     * Encrypts the given text using a Rail Fence cipher.
     * The number of rails is calculated from the key.
     */
    @Override
    public String encrypt(String text, String key) {
        int rails = calculateRails(key);
        return railFenceEncryptor.encrypt(text, rails);
    }

    /**
     * Decrypts the given text using a Rail Fence cipher.
     * The number of rails is calculated from the key.
     */
    @Override
    public String decrypt(String text, String key) {
        int rails = calculateRails(key);
        return railFenceDecryptor.decrypt(text, rails);
    }
    
    /**
     * Calculates the number of rails to use in the Rail Fence cipher.
     * Ensures there are always at least 2 rails.
     */
    private int calculateRails(String key) {
        int keyValue = keyConverter.convertToNumber(key);
        return Math.max(2, (keyValue % 10) + 2);
    }
}

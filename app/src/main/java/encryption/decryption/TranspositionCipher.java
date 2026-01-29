package encryption.decryption;

public class TranspositionCipher implements Cipher {
    
    private KeyConverter keyConverter;
    private RailFenceEncryptor railFenceEncryptor;
    private RailFenceDecryptor railFenceDecryptor;
    
    public TranspositionCipher() {
        this.keyConverter = new KeyConverter();
        this.railFenceEncryptor = new RailFenceEncryptor();
        this.railFenceDecryptor = new RailFenceDecryptor();
    }
    
    @Override
    public String encrypt(String text, String key) {
        int rails = calculateRails(key);
        return railFenceEncryptor.encrypt(text, rails);
    }

    @Override
    public String decrypt(String text, String key) {
        int rails = calculateRails(key);
        return railFenceDecryptor.decrypt(text, rails);
    }
    
    private int calculateRails(String key) {
        int keyValue = keyConverter.convertToNumber(key);
        return Math.max(2, (keyValue % 10) + 2);
    }
}

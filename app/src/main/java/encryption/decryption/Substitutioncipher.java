package encryption.decryption;

public class Substitutioncipher implements Cipher {
    
    private KeyConverter keyConverter;
    
    public Substitutioncipher() {
        this.keyConverter = new KeyConverter();
    }
    
    @Override
    public String encrypt(String text, String key) {
        int shiftValue = keyConverter.convertToShiftValue(key);
        StringBuilder result = new StringBuilder();
        
        for (char c : text.toCharArray()) {
            char encrypted = shiftCharacter(c, shiftValue, true);
            result.append(encrypted);
        }
        
        return result.toString();
    }
    
    @Override
    public String decrypt(String text, String key) {
        int shiftValue = keyConverter.convertToShiftValue(key);
        StringBuilder result = new StringBuilder();
        
        for (char c : text.toCharArray()) {
            char decrypted = shiftCharacter(c, shiftValue, false);
            result.append(decrypted);
        }
        
        return result.toString();
    }
    

    private char shiftCharacter(char c, int shift, boolean encrypt) {
        int charValue = (int) c;
        
        if (encrypt) {
            int shifted = (charValue + shift) % 256;
            return (char) shifted;
        } else {
            int shifted = (charValue - shift) % 256;
            if (shifted < 0) {
                shifted += 256;
            }
            return (char) shifted;
        }
    }
}
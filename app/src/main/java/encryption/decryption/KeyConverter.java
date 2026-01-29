package encryption.decryption;

public class KeyConverter {

    public int convertToShiftValue(String key) {
        int value = convertToNumber(key);
        return normalizeToByteRange(value);
    }
    
    public int convertToNumber(String key) {
        try {
            return Integer.parseInt(key);
        } catch (NumberFormatException e) {
            return sumAsciiValues(key);
        }
    }
    
 
    private int sumAsciiValues(String text) {
        int sum = 0;
        for (char c : text.toCharArray()) {
            sum += (int) c;
        }
        return sum;
    }
  
    private int normalizeToByteRange(int value) {
        int normalized = value % 256;
        if (normalized < 0) {
            normalized += 256;
        }
        return normalized;
    }
}

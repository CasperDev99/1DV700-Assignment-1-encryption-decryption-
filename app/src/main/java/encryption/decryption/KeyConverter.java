package encryption.decryption;

public class KeyConverter {

    /**
     * Converts a key into a shift value suitable for byte-based ciphers.
     */
    public int convertToShiftValue(String key) {
        int value = convertToNumber(key);
        return normalizeToByteRange(value);
    }
    
    /**
     * Converts a key string into a numeric value.
     */
    public int convertToNumber(String key) {
        try {
            return Integer.parseInt(key);
        } catch (NumberFormatException e) {
            return sumAsciiValues(key);
        }
    }
    
    /**
     * Calculates the sum of ASCII values for all characters in the text.
     * Used when the key is not a valid integer.
     */
    private int sumAsciiValues(String text) {
        int sum = 0;
        for (char c : text.toCharArray()) {
            sum += (int) c;
        }
        return sum;
    }
  
    /**
     * Normalizes a numeric value into the byte range 0–255.
     * Ensures the result is always non-negative.
     */
    private int normalizeToByteRange(int value) {
        int normalized = value % 256;
        if (normalized < 0) {
            normalized += 256;
        }
        return normalized;
    }
}

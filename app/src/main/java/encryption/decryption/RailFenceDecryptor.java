package encryption.decryption;

import java.util.ArrayList;
import java.util.List;

public class RailFenceDecryptor {

    /**
     * Decrypts the given ciphertext using the specified number of rails.
     */
    public String decrypt(String text, int rails) {
        if (rails <= 1 || text.length() <= 1) {
            return text;
        }
        
        int[] railLengths = calculateRailLengths(text.length(), rails);
        List<StringBuilder> fence = extractRails(text, railLengths);
        return readFromFenceInOrder(fence, rails, text.length());
    }
    
    /**
     * Calculates how many characters belong to each rail
     * by simulating the zigzag traversal used in encryption.
     */
    private int[] calculateRailLengths(int textLength, int rails) {
        int[] lengths = new int[rails];
        int rail = 0;
        int direction = 1;
        
        for (int i = 0; i < textLength; i++) {
            lengths[rail]++;
            rail = moveToNextRail(rail, direction, rails);
            direction = updateDirection(rail, rails, direction);
        }
        
        return lengths;
    }

    /**
     * Determines the next rail index based on direction.
     */
    private int moveToNextRail(int currentRail, int direction, int rails) {
        return currentRail + direction;
    }
    
    /**
     * Reverses direction when reaching the top or bottom rail.
     */
    private int updateDirection(int rail, int rails, int direction) {
        if (rail == 0) {
            return 1;
        } else if (rail == rails - 1) {
            return -1;
        }
        return direction;
    }
    
    /**
     * Splits the ciphertext into separate rails based on
     * the calculated rail lengths.
     */
    private List<StringBuilder> extractRails(String text, int[] railLengths) {
        List<StringBuilder> fence = new ArrayList<>();
        int index = 0;
        
        for (int i = 0; i < railLengths.length; i++) {
            fence.add(new StringBuilder());
            for (int j = 0; j < railLengths[i]; j++) {
                fence.get(i).append(text.charAt(index++));
            }
        }
        
        return fence;
    }
    
    /**
     * Reads characters from the fence in zigzag order
     * to reconstruct the original plaintext.
     */
    private String readFromFenceInOrder(List<StringBuilder> fence, int rails, int textLength) {
        StringBuilder decrypted = new StringBuilder();
        int rail = 0;
        int direction = 1;
        int[] railIndices = new int[rails];
        
        for (int i = 0; i < textLength; i++) {
            decrypted.append(fence.get(rail).charAt(railIndices[rail]++));
            rail = moveToNextRail(rail, direction, rails);
            direction = updateDirection(rail, rails, direction);
        }
        
        return decrypted.toString();
    }
}

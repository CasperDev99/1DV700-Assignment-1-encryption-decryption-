package encryption.decryption;

import java.util.ArrayList;
import java.util.List;

public class RailFenceEncryptor {

    
    /**
     * Encrypts the given text using the specified number of rails.
     */
    public String encrypt(String text, int rails) {
        if (rails <= 1 || text.length() <= 1) {
            return text;
        }
        
        List<StringBuilder> fence = createFence(rails);
        fillFenceWithText(fence, text, rails);
        return readFromFence(fence);
    }
    
    /**
     * Creates an empty fence structure with one StringBuilder per rail.
     */
    private List<StringBuilder> createFence(int rails) {
        List<StringBuilder> fence = new ArrayList<>();
        for (int i = 0; i < rails; i++) {
            fence.add(new StringBuilder());
        }
        return fence;
    }
    
    /**
     * Fills the fence with characters from the text in a zigzag pattern.
     */
    private void fillFenceWithText(List<StringBuilder> fence, String text, int rails) {
        int rail = 0;
        int direction = 1;
        
        for (char c : text.toCharArray()) {
            fence.get(rail).append(c);
            rail = moveToNextRail(rail, direction, rails);
            direction = updateDirection(rail, rails, direction);
        }
    }
    
    /**
     * Calculates the next rail index based on the current direction.
     */
    private int moveToNextRail(int currentRail, int direction, int rails) {
        return currentRail + direction;
    }
    
    /**
     * Updates the direction when reaching the top or bottom rail.
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
     * Reads the characters from the fence row by row to form
     * the final encrypted string.
     */
    private String readFromFence(List<StringBuilder> fence) {
        StringBuilder encrypted = new StringBuilder();
        for (StringBuilder railContent : fence) {
            encrypted.append(railContent);
        }
        return encrypted.toString();
    }

}

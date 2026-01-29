package encryption.decryption;

import java.util.ArrayList;
import java.util.List;

public class RailFenceDecryptor {

    public String decrypt(String text, int rails) {
        if (rails <= 1 || text.length() <= 1) {
            return text;
        }
        
        int[] railLengths = calculateRailLengths(text.length(), rails);
        List<StringBuilder> fence = extractRails(text, railLengths);
        return readFromFenceInOrder(fence, rails, text.length());
    }
    
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
    
    private int moveToNextRail(int currentRail, int direction, int rails) {
        return currentRail + direction;
    }
    
    private int updateDirection(int rail, int rails, int direction) {
        if (rail == 0) {
            return 1;
        } else if (rail == rails - 1) {
            return -1;
        }
        return direction;
    }
    
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

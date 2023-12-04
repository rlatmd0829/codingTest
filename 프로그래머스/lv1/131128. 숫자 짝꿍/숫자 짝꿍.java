import java.util.ArrayList;
class Solution {
    public String solution(String X, String Y) {
        int[] xCount = countDigits(X);
        int[] yCount = countDigits(Y);
        StringBuilder sb = new StringBuilder();
        boolean hasPair = false;
        for (int i = 9; i >= 0; i--) {
            int pairCount = Math.min(xCount[i], yCount[i]);
            for (int j = 0; j < pairCount; j++) {
                sb.append(i);
                hasPair = true;
            }
        }
        if (!hasPair) {
            return "-1";
        }
        if (sb.charAt(0) == '0') {
            return "0";
        }
        
        return sb.toString();
    }
    
    private static int[] countDigits(String number) {
        int[] count = new int[10];
        for (char c : number.toCharArray()) {
            count[c - '0']++;
        }
        return count;
    }
}
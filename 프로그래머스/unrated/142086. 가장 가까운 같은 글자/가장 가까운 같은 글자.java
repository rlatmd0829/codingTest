import java.util.HashMap;
class Solution {
    public int[] solution(String s) {
        int answer = 0;
        char[] c = s.toCharArray();
        int[] result = new int[c.length];
        HashMap<Character, Integer> map = new HashMap();
        for (int i = 0; i < c.length; i++) {
            if (!map.containsKey(c[i])) {
                map.put(c[i], answer);
                result[i] = -1;
            } else {
                int location = answer - map.get(c[i]);
                map.put(c[i], answer);
                result[i] = location;
            }
            answer++;
        }
        return result;
    }
}
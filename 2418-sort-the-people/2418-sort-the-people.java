import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            map.put(heights[i], names[i]);
        }
        List<Map.Entry<Integer, String>> entries = map.entrySet().stream()
                .sorted(Map.Entry.<Integer, String>comparingByKey().reversed())
                .collect(Collectors.toList());
        String[] result = new String[names.length];
        for (int i = 0; i < entries.size(); i++) {
            result[i] = entries.get(i).getValue();
        }
        return result;
    }
}
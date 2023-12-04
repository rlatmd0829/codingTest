import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : tangerine) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        List<Map.Entry<Integer, Integer>> collect = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toList());

        for (Map.Entry<Integer, Integer> integerIntegerEntry : collect) {
            k -= integerIntegerEntry.getValue();
            answer++;
            if (k <= 0) {
                break;
            }
        }
        return answer;
    }
}
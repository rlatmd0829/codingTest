import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

		for (int i = 0; i < discount.length - 9; i++) {
			Map<String, Integer> map = new HashMap<>();
			for (int j= 0; j < want.length; j++) {
				map.put(want[j], number[j]);
			}
			for (int j = i; j < i+10; j++) {
				if (map.containsKey(discount[j])) {
					map.put(discount[j], map.get(discount[j])-1);
				}
			}
			int max = Collections.max(map.values());
			if (max == 0) {
				answer++;
			}
		}
		return answer;
    }
}
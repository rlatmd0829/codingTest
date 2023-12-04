import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] book_time) {
        Map<Integer, Integer> map = new HashMap<>();
		for (String[] strings : book_time) {
			String[] stringTimeStart = strings[0].split(":");
			int timeStart = Integer.parseInt(stringTimeStart[0]) * 60 + Integer.parseInt(stringTimeStart[1]);

			String[] stringTimeEnd = strings[1].split(":");
			int timeEnd = Integer.parseInt(stringTimeEnd[0]) * 60 + Integer.parseInt(stringTimeEnd[1]) + 9;

			for (int i = timeStart; i <= timeEnd; i++) {
				if (map.containsKey(i)) {
					map.put(i, map.get(i)+1);
				} else {
					map.put(i, 1);
				}
			}
		}
		return Collections.max(map.values());
    }
}
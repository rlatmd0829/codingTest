import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";

		Map<String, Integer> map = new HashMap<>();
		map.put("R", 0);
		map.put("T", 0);
		map.put("C", 0);
		map.put("F", 0);
		map.put("J", 0);
		map.put("M", 0);
		map.put("A", 0);
		map.put("N", 0);

		for (int i = 0; i < survey.length; i++) {
			if (choices[i] < 4) {
				int score = 0;
				if (choices[i] == 1) {
					score = 3;
				}
				if (choices[i] == 2) {
					score = 2;
				}
				if (choices[i] == 3) {
					score = 1;
				}
				String first = String.valueOf(survey[i].charAt(0));
				int value = map.get(first);
				map.put(first, value + score);
			} else if (choices[i] > 4) {
				int score = choices[i] - 4;
				String second = String.valueOf(survey[i].charAt(1));
				int value = map.get(second);
				map.put(second, value + score);
			}
		}

		answer += map.get("R") >= map.get("T") ? "R" : "T";
		answer += map.get("C") >= map.get("F") ? "C" : "F";
		answer += map.get("J") >= map.get("M") ? "J" : "M";
		answer += map.get("A") >= map.get("N") ? "A" : "N";

		return answer;
    }
}
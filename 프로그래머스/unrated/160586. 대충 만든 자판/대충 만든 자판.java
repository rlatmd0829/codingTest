import java.util.ArrayList;
import java.util.HashMap;


class Solution {
    public ArrayList<Integer> solution(String[] keymap, String[] targets) {
		ArrayList<Integer> answer = new ArrayList<>();
		HashMap<Character, Integer> hashMap = new HashMap<>();

		for (int i = 0; i < keymap.length; i++) {
			char[] charKey = keymap[i].toCharArray();
			for (int j = 0; j < charKey.length; j++) {
				if (hashMap.containsKey(charKey[j])) {
					if (hashMap.get(charKey[j]) > j+1) {
						hashMap.put(charKey[j], j+1);
					}
				} else {
					hashMap.put(charKey[j], j+1);
				}
			}
		}


		for (int i = 0; i < targets.length; i++) {
			char[] targetChar = targets[i].toCharArray();
			int cnt = 0;
			for (int j = 0; j < targetChar.length; j++) {
				int get = hashMap.getOrDefault(targetChar[j], -1);
				if (get == -1) {
					cnt = -1;
					break;
				} else {
					cnt += get;
				}
			}
            
			answer.add(cnt);
            
		}
		return answer;
	}
}
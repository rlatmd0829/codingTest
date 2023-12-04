import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int solution(int[] cards) {
        int answer = 0;
		List<Integer> result = new ArrayList<>();

		List<Integer> list = new ArrayList<>();
		while (true) {

			int index = 0;
			int count = 0;
			for (int i = 0; i < cards.length; i++) {
				if (!list.contains(cards[i])) {
					list.add(cards[i]);
					index = cards[i];
					count++;
					break;
				}
			}
			while (true) {
				if (!list.contains(cards[index-1])) {
					list.add(cards[index-1]);
					count++;
				} else {
					break;
				}
				index = cards[index-1];
			}
			result.add(count);
			if (list.size() == cards.length) {
				if (result.size() == 1) {
					return 0;
				}
				break;
			}
		}
		Collections.sort(result);
		answer = result.get(result.size()-1) * result.get(result.size()-2);

		return answer;
    }
}
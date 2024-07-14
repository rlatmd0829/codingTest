import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] sequence, int k) {
		int[] answer = new int[2];

		int lt = 0;
		int rt = 0;
		int temp = sequence[0];
		// List<Integer> tempList = new ArrayList<>();
		// tempList.add(sequence[0]);
		int tempCnt = 1;
		int minn = Integer.MAX_VALUE;

		while (true) {
			if (temp == k) {
				if (minn > tempCnt) {
					minn = tempCnt;
					answer[0] = lt;
					answer[1] = rt;
				}
				rt++;
				if (rt == sequence.length) {
					break;
				}
				temp+=sequence[rt];
				// tempList.add(sequence[rt]);
				tempCnt++;
			} else if (temp < k) {
				rt++;
				if (rt == sequence.length) {
					break;
				}
				temp+=sequence[rt];
				// tempList.add(sequence[rt]);
				tempCnt++;
			} else {
				// tempList.remove(0);
				tempCnt--;
				temp-=sequence[lt];
				lt++;
			}
		}

		return answer;
	}
}
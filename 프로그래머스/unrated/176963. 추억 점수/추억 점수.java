import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
		int count = 0;
		for (String[] strings : photo) {
			List ex = Arrays.asList(strings);
			int sum = 0;
			for (int i = 0; i < name.length; i++) {
				if (ex.contains(name[i])) {
					sum += yearning[i];
				}
			}
			answer[count] = sum;
			count++;
		}
		return answer;
    }
}
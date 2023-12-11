import java.util.Arrays;

class Solution {
    
    static int maxx = 0;
	static int[] maxArray;
	static int[] init;
    
    public static int[] solution(int n, int[] info) {

		init = info.clone();
		maxArray = new int[info.length];

		recursive(n, info, 0);
		// System.out.println(maxx);
		// System.out.println(Arrays.toString(maxArray));
		int sum = Arrays.stream(maxArray).sum();
		if (sum == 0 || maxx == 0) { // 서로 비겼을경우
			return new int[]{-1};
		}
		return maxArray;
	}

	public static void recursive(int n, int[] info, int index) {
		if (n == 0 || index == info.length) {
			int lion = 0;
			int apeach = 0;
			for (int i = 0; i < info.length; i++) {
				if (info[i] > 0) {
					apeach += 10 - i;
				} else if (info[i] == 0 && init[i] != 0) {
					apeach += 10 - i;
				}
				else if (info[i] < 0) {
					lion += 10 - i;
				}
			}
			int cloneMaxx = maxx;
			maxx = Math.max(maxx, lion - apeach);

			if (cloneMaxx != maxx) {
				for (int i = 0; i < maxArray.length; i++) {
					if (init[i] == info[i]) {
						maxArray[i] = 0;
					} else if (init[i] > info[i]) { // lion 이 던진것
						maxArray[i] = init[i] - info[i];
					}
				}
			}

			if (maxx == lion - apeach) { // maxx 점수가 같을경우에는 낮은 점수에 더 많이 맞춘거를 택한다.
				int[] temp = new int[maxArray.length];
				for (int i = 0; i < maxArray.length; i++) {
					if (init[i] == info[i]) {
						temp[i] = 0;
					} else if (init[i] > info[i]) { // lion 이 던진것
						temp[i] = init[i] - info[i];
					}
				}

				for (int i = temp.length-1; i >= 0; i--) {
					if (temp[i] > maxArray[i]) {
						maxArray = temp.clone();
						return;
					} else if (temp[i] < maxArray[i]) {
						return;
					}
				}
			}

			return;
		}

		int[] temp = info.clone();
		temp[index] -= 1;
		recursive(n-1, temp, index);
		recursive(n, info, index + 1);

	}
}
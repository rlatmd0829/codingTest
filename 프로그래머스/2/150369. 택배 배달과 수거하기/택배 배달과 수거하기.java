import java.util.Arrays;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
		long answer = 0;

		int deliveriesCap = cap;
		int pickupsCap = cap;

		for (int i = n-1; i >= 0; i--) { // 배열을 맨뒤에 부터 돌아준다.
			deliveriesCap -= deliveries[i];
			pickupsCap -= pickups[i];

			while (true) {
				if (deliveriesCap >= cap && pickupsCap >= cap) {
					break;
				}
				deliveriesCap += cap;
				pickupsCap += cap;
				answer += (i + 1);
			}
		}
		return answer * 2;
	}
}
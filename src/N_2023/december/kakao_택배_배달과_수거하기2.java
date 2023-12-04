package N_2023.december;

public class kakao_택배_배달과_수거하기2 {
	public static void main(String[] args) {
		int cap = 2;
		int n = 7;
		int[] deliveries = {1, 0, 2, 0, 1, 0, 2};
		int[] pickups = {0, 2, 0, 1, 0, 2, 0};
		System.out.println(solution(cap, n, deliveries, pickups));
	}

	public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
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

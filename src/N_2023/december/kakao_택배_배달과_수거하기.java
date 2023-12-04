package N_2023.december;

public class kakao_택배_배달과_수거하기 {
	public static void main(String[] args) {
		int cap = 2;
		int n = 7;
		int[] deliveries = {1, 0, 2, 0, 1, 0, 2};
		int[] pickups = {0, 2, 0, 1, 0, 2, 0};
		// 30

		// int cap = 4;
		// int n = 5;
		// int[] deliveries = {1, 0, 3, 1, 2};
		// int[] pickups = {0, 3, 0, 4, 0};
		// 16

		// int cap = 1;
		// int n = 5;
		// int[] deliveries = {0, 0, 1, 0, 0};
		// int[] pickups = {0, 0, 0, 0, 0};
		// 6

		// int cap = 2;
		// int n = 2;
		// int[] deliveries = {0, 0};
		// int[] pickups = {0, 4};
		// 8

		// int cap = 3;
		// int n = 2;
		// int[] deliveries = {2, 4};
		// int[] pickups = {4, 2};
		// 8
		System.out.println(solution(cap, n, deliveries, pickups));
	}

	public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
		long answer = 0;

		for (int i = n-1; i >= -1; i--) {
			if (i != n-1 && (deliveries[i+1] != 0 || pickups[i+1] != 0)) {
				i += 1;
			}

			if (i == -1) {
				break;
			}

			if (deliveries[i] == 0 && pickups[i] == 0) {
				continue;
			}

			int deliveriesCap = cap;
			int pickupsCap = cap;

			int j = i;

			while (true) {
				if (deliveriesCap >= deliveries[j] && pickupsCap >= pickups[j]) {
					deliveriesCap -= deliveries[j];
					pickupsCap -= pickups[j];
					deliveries[j] = 0;
					pickups[j] = 0;
					j--;
				} else if (deliveriesCap >= deliveries[j]) {
					deliveriesCap -= deliveries[j];
					pickups[j] -= pickupsCap;
					pickupsCap = 0;
					deliveries[j] = 0;
					j--;
				} else if (pickupsCap >= pickups[j]) {
					pickupsCap -= pickups[j];
					deliveries[j] -= deliveriesCap;
					deliveriesCap = 0;
					pickups[j] = 0;
					j--;
				} else {
					deliveries[j] -= deliveriesCap;
					pickups[j] -= pickupsCap;
					deliveriesCap = 0;
					pickupsCap = 0;
				}
				if ((deliveriesCap == 0 && pickupsCap == 0)) {
					answer += (i+1) * 2;
					break;
				}
				if (j == -1) {
					answer += (i+1) * 2;
					break;
				}
			}
		}
		return answer;
	}
}

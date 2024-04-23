package N_2024.april;

public class 붕대_감기 {
	public static void main(String[] args) {
		// int[] bandages = {5, 1, 5};
		// int health = 30;
		// int[][] attacks = {{2, 10}, {9, 15}, {10, 5}, {11, 5}};

		int[] bandages = {3, 2, 7};
		int health = 20;
		int[][] attacks = {{1, 15}, {5, 16}, {8, 6}};

		int result = solution(bandages, health, attacks);
		System.out.println(result);
	}

	public static int solution(int[] bandage, int health, int[][] attacks) {
		int originHealth = health;

		int successive = 0;
		health -= attacks[0][1];

		for (int i = 1; i < attacks.length; i++) {
			successive = attacks[i][0] - attacks[i-1][0] - 1;
			int successCount = successive / bandage[0];

			health += successive * bandage[1];
			health += successCount * bandage[2];

			if (originHealth < health) {
				health = originHealth;
			}

			health -= attacks[i][1];

			if (health <= 0) {
				return -1;
			}
		}

		return health;
	}
}

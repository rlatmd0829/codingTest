class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
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
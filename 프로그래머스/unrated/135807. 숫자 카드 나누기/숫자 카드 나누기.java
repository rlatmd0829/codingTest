class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
		int gcdA = arrayA[0];
		int gcdB = arrayB[0];

		for (int i = 1; i < arrayA.length; i++) {
			gcdA = findGCD(gcdA, arrayA[i]);
		}
		for (int i = 1; i < arrayB.length; i++) {
			gcdB = findGCD(gcdB, arrayB[i]);
		}
		int max = Math.max(gcdA, gcdB);
		for (int i = max; i > 0; i--) {
			int countA = 0;
			for (int j = 0; j < arrayA.length; j++) {
				if (arrayA[j] % i == 0) {
					countA++;
				}
			}
			int countB = 0;
			for (int j = 0; j < arrayB.length; j++) {
				if (arrayB[j] % i == 0) {
					countB++;
				}
			}
			if (countA == arrayA.length && countB == 0 ||
			countB == arrayB.length && countA == 0) {
				answer = i;
				break;
			}
		}
		return answer;
    }
    
    public int findGCD(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return findGCD(b, a % b);
		}
	}
}
package N_2023.december;

public class kakao_k진수에서_소수_개수_구하기2 {
	public static void main(String[] args) {
		int n = 11000011;
		int k = 10;
		System.out.println(solution(n, k));
	}

	public static int solution(int n, int k) {
		int answer = 0;

		String number = Long.toString(n, k);

		String[] numbers = number.split("0");

		for (String s : numbers) {
			if (s.isEmpty()) {
				continue;
			}
			if (isPrime(Long.parseLong(s))) {
				answer++;
			}
		}
		return answer;
	}

	private static boolean isPrime(long n) {
		if (n == 1) {
			return false;
		}
		for (int i = 2; i <= (int)Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}

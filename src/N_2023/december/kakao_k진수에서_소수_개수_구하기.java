package N_2023.december;

public class kakao_k진수에서_소수_개수_구하기 {
	public static void main(String[] args) {
		int n = 437674;
		int k = 3;
		System.out.println(solution(n, k));
	}

	public static int solution(int n, int k) {
		int answer = 0;

		String number = Long.toString(n, k);

		char[] chars = number.toCharArray();

		String temp = "";

		for (int i = 0; i < chars.length; i++) {
			if (chars[i] != '0') {
				temp += chars[i];
			} else {
				temp = "";
			}
			if (!temp.isEmpty() && isPrime(Long.parseLong(temp))) {
				if (i - temp.length() == -1 && chars[i+1] == '0') {
					answer++;
				} else if (i == chars.length-1 && chars[i-temp.length()] == '0') {
					answer++;
				} else if (chars[i+1] == '0' && chars[i-temp.length()] == '0') {
					answer++;
				}
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

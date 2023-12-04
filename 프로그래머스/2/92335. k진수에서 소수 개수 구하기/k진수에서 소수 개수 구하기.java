class Solution {
    public int solution(int n, int k) {
		int answer = 0;

		String number = Long.toString(n, k);

		String[] numbers = number.split("0");

		for (String s : numbers) {
            if (s.equals("")) {
				continue;
			}
			if (isPrime(Long.parseLong(s))) {
				answer++;
			}
		}
		return answer;
	}

	private boolean isPrime(long n) {
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
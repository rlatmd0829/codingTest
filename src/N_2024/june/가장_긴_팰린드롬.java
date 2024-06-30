package N_2024.june;

public class 가장_긴_팰린드롬 {
	public static void main(String[] args) {
		String s = "abcdcba";
		System.out.println(solution(s));
	}

	public static int solution(String s) {
		int answer = 0;

		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				if (isPalindrome(s, i, j)) {
					answer = Math.max(answer, j - i + 1);
				}
			}
		}

		return answer;
	}
	
	public static boolean isPalindrome(String s, int left, int right) {
		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}

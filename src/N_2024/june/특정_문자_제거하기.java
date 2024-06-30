package N_2024.june;

public class 특정_문자_제거하기 {
	public static void main(String[] args) {
		String my_string = "abcdef";
		String letter = "f";
		System.out.println(solution(my_string, letter));
	}

	public static String solution(String my_string, String letter) {
		String answer = "";

		for (int i = 0; i < my_string.length(); i++) {
			if (!String.valueOf(my_string.charAt(i)).equals(letter)) {
				answer += String.valueOf(my_string.charAt(i));
			}
		}

		return answer;
	}
}

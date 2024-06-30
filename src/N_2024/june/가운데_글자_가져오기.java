package N_2024.june;

public class 가운데_글자_가져오기 {
	public static void main(String[] args) {
		String s = "qwer";
		System.out.println(solution(s));

	}

	public static String solution(String s) {
		int sLength = s.length();
		int index = sLength / 2;
		if (sLength % 2 == 0) {
			return s.charAt(index-1) + String.valueOf(s.charAt(index));
		} else {
			return String.valueOf(s.charAt(index));
		}
	}
}

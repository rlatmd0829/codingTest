package N_2024.june;

public class 핸드폰_번호_가리기 {
	public static void main(String[] args) {
		String phone_number = "01033334444";
		System.out.println(solution(phone_number));
	}

	public static String solution(String phone_number) {
		StringBuilder answer = new StringBuilder();

		String left = phone_number.substring(0, phone_number.length() - 4);
		String right = phone_number.substring(phone_number.length()-4);

		for (int i = 0; i < left.length(); i++) {
			answer.append("*");
		}
		return answer + right;
	}
}

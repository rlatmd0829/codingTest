class Solution {
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
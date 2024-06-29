class Solution {
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
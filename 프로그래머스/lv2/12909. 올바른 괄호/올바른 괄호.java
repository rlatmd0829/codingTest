class Solution {
    boolean solution(String s) {
        boolean answer = true;
		int open = 0;
		int close = 0;
		char[] c = s.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == '(') {
				open++;
			} else {
				close++;
				if (close > open) {
					return false;
				}
			}
		}
		if (open != close) {
			return false;
		}
		return answer;
    }
}
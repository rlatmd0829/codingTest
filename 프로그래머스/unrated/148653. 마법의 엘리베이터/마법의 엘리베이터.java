class Solution {
    public int solution(int storey) {
        int answer = 0;
		String numStr = Integer.toString(storey);
		char[] charArr = numStr.toCharArray();
		int[] digitArr = new int[charArr.length];

		for (int i = 0; i < charArr.length; i++) {
			digitArr[i] = Character.getNumericValue(charArr[i]);
		}

		for (int i = digitArr.length - 1; i >= 0; i--) {
			if (digitArr[i] >= 6) {
				answer += 10 - digitArr[i];
				if (i == 0) {
					answer++;
				} else {
					digitArr[i - 1]++;
				}
			} else if (digitArr[i] == 5) {
				if (i == 0) {
					answer += digitArr[i];
				} else {
					if (digitArr[i - 1] >= 5) {
						answer += 10 - digitArr[i];
						digitArr[i-1]++;
					} else {
						answer += digitArr[i];
					}
				}
			} else {
				answer += digitArr[i];
			}
		}
		return answer;
    }
}
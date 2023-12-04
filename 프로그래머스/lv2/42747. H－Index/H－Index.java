class Solution {
    public int solution(int[] citations) {
        int length = citations.length;
		while (true) {
			int count = 0;
			for (int citation : citations) {
				if (citation >= length) {
					count++;
				}
			}

			if (count >= length) {
				break;
			}
			
			length--;
		}
		return length;
    }
}
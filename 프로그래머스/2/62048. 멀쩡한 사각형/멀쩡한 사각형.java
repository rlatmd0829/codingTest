class Solution {
    public long solution(int w, int h) {
		long answer = (long)w * h;
		if (w > h) {
			int temp  = w;
			w = h;
			h = temp;
		}
		int gcd = GCD(w,h);
		int gcdW = w / gcd;
		int gcdH = h / gcd;
		long sum = (long)(gcdW + gcdH - 1) * gcd;
		return answer - sum;
	}

	public int GCD(int a, int b) {
		if (a % b == 0) {
			return b;
		} else {
			return GCD(b, a % b);
		}
	}
}
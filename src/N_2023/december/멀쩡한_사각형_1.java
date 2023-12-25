package N_2023.december;

public class 멀쩡한_사각형_1 {
	public static void main(String[] args) {
		int w = 8;
		int h = 12;
		System.out.println(solution(w, h));
	}

	public static long solution(int w, int h) {
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

	public static int GCD(int a, int b) {
		if (a % b == 0) {
			return b;
		} else {
			return GCD(b, a % b);
		}
	}
}

package N_2023.december;

public class 멀쩡한_사각형_2 {
	public static void main(String[] args) {
		int w = 8;
		int h = 12;
		System.out.println(solution(w, h));
	}

	public static long solution(int w, int h) {
		long wh = (long)w * h;

		if (w == h) {
			return wh - w;
		} else if (w > h) {
			return wh - h * 2L;
		} else {
			return wh - w * 2L;
		}
	}
}

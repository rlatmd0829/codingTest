package N_2024.june;

public class 문자열_내_p와_y의_개수 {
	public static void main(String[] args) {
		String s = "pPoooyY";
		System.out.println(solution(s));
	}

	public static boolean solution(String s) {
		char[] chars = s.toCharArray();
		int pcnt = 0;
		int ycnt = 0;

		for (char aChar : chars) {
			if (aChar == 'p' || aChar == 'P') {
				pcnt++;
			} else if (aChar == 'y' || aChar == 'Y') {
				ycnt++;
			}
		}

		if (pcnt == 0 && ycnt == 0) {
			return true;
		}
		if (pcnt == ycnt) {
			return true;
		}

		return false;
	}


}

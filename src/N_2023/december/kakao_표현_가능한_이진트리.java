package N_2023.december;

import java.util.ArrayList;
import java.util.List;

public class kakao_표현_가능한_이진트리 {
	public static void main(String[] args) {
		long[] numbers = {7, 42, 5};
		List<Integer> answers = solution(numbers);
		for (int answer : answers) {
			System.out.print(answer + " ");
		}
		System.out.println();
	}

	public static List<Integer> solution(long[] numbers) {
		List<Integer> answer = new ArrayList<>();

		for (long number : numbers) {
			String binaryNumber = Long.toBinaryString(number);
			boolean check = true;

			if (binaryNumber.length() % 2 == 0) {
				binaryNumber = "0" + binaryNumber;
				char[] chars = binaryNumber.toCharArray();
				for (int i = 1; i < chars.length; i+=2) {
					if (chars[i] == '0') {
						answer.add(0);
						check = false;
						break;
					}
				}
				if (check) {
					answer.add(1);
				}
			} else {
				char[] chars = binaryNumber.toCharArray();
				for (int i = 1; i < chars.length; i+=2) {
					if (chars[i] == '0') {
						answer.add(0);
						check = false;
						break;
					}
				}
				if (check) {
					answer.add(1);
				}
			}
		}


		return answer;
	}
}

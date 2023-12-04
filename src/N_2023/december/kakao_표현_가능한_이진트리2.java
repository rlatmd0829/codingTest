package N_2023.december;

import java.util.ArrayList;
import java.util.List;

public class kakao_표현_가능한_이진트리2 {

	static boolean check = false;
	public static void main(String[] args) {
		long[] numbers = {128};
		List<Integer> answers = solution(numbers);
		for (int answer : answers) {
			System.out.print(answer + " ");
		}
		System.out.println();
	}

	public static List<Integer> solution(long[] numbers) {
		List<Integer> answer = new ArrayList<>();

		for (long number : numbers) {
			check = false;
			String binaryNumber = Long.toBinaryString(number);

			int level = 1;
			int nodeCount = 1;

			while (binaryNumber.length() > nodeCount) {
				level += 1;
				nodeCount = (int)(Math.pow(2, level) - 1);
			}

			int remain = nodeCount - binaryNumber.length();
			for (int i = 0; i < remain; i++) {
				binaryNumber = "0" + binaryNumber;
			}

			recursive(binaryNumber);

			if (check) {
				answer.add(0);
			} else {
				answer.add(1);
			}
		}

		return answer;
	}

	public static void recursive(String binaryNumber) {
		int root = binaryNumber.length() / 2;
		char[] c = binaryNumber.toCharArray();

		int cnt = 0;

		for (char c1 : c) {
			if (c1 == '0') {
				cnt++;
			}
		}

		if (cnt == c.length) {
			return;
		}

		if (c[root] == '0') {
			check = true;
			return;
		}

		String left = binaryNumber.substring(0, root);
		if (left.length() < 3) {
			return;
		}
		recursive(left);

		String right = binaryNumber.substring(root+1);
		if (right.length() < 3) {
			return;
		}
		recursive(right);
	}
}

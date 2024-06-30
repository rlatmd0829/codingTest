package N_2024.june;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 아나그램_해쉬 {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		String input1 = in.nextLine();
		String input2 = in.nextLine();
		System.out.println(solution(input1, input2));

	}

	public static String solution(String input1, String input2) {
		Map<Character, Integer> map1 = new HashMap<>();
		Map<Character, Integer> map2 = new HashMap<>();

		for (int i = 0; i < input1.length(); i++) {
			map1.put(input1.charAt(i), map1.getOrDefault(input1.charAt(i), 0) + 1);
			map2.put(input2.charAt(i), map2.getOrDefault(input2.charAt(i), 0) + 1);
		}

		if (map1.size() != map2.size()) {
			return "NO";
		}

		for (Character key : map1.keySet()) {
			if (!map2.containsKey(key)) {
				return "NO";
			}
			if (!map1.get(key).equals(map2.get(key))) {
				return "NO";
			}
		}

		return "YES";
	}
}

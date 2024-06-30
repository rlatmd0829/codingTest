package N_2024.june;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class 학급_회장 {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int input1 = in.nextInt();
		String a = in.nextLine();
		String input2 = in.nextLine();
		System.out.println(solution(input1, input2));
	}

	public static String solution(int input1, String input2) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < input1-1; i++) {
			map.put(input2.charAt(i), map.getOrDefault(input2.charAt(i), 0) + 1);
		}

		// Map.Entry 리스트에 모든 항목 추가
		List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());

		// value 기준으로 정렬
		list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

		return String.valueOf(list.get(0).getKey());

	}
}

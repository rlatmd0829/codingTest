package inflearn.section4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 학급_회장_1 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int N = in.nextInt();
		String alpha = in.next();

		Map<String, Integer> map = new HashMap<>();
		String[] alphas =alpha.split("");
		for (String s : alphas) {
			map.put(s, map.getOrDefault(s, 0) + 1);
		}

		Map.Entry<String, Integer> stringIntegerEntry = map.entrySet().stream()
			.max(Map.Entry.comparingByValue())
			.orElse(null);

		System.out.println(stringIntegerEntry.getKey());

	}
}

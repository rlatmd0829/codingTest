package inflearn.section4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 아나그램_2 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		String A = in.next();
		String B = in.next();
		String[] As = A.split("");
		String[] Bs = B.split("");

		Map<String, Integer> map = new HashMap<>();

		for (String a : As) {
			map.put(a, map.getOrDefault(a, 0) + 1);
		}


		for (String b : Bs) {
			map.put(b, map.getOrDefault(b, 0) - 1);
		}

		for (Integer value : map.values()) {
			if (value != 0) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
}

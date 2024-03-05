package inflearn.section6;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 중복_확인_5 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int input1 = in.nextInt();
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < input1; i++) {
			int temp = in.nextInt();
			if (map.containsKey(temp)) {
				System.out.println("D");
				return;
			} else {
				map.put(temp, 1);
			}
		}
		System.out.println("U");
	}
}

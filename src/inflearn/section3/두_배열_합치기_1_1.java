package inflearn.section3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 두_배열_합치기_1_1 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int N = in.nextInt();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			int a = in.nextInt();
			list.add(a);
		}

		int M = in.nextInt();
		for (int i = 0; i < M; i++) {
			int b = in.nextInt();
			list.add(b);
		}

		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}
}

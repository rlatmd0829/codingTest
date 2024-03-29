package inflearn.section3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 두_배열_합치기_1_2 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int N = in.nextInt();
		List<Integer> list = new ArrayList<>();
		int[] arr1 = new int[N];
		int p1 = 0;
		int p2 = 0;
		for (int i = 0; i < N; i++) {
			arr1[i] = in.nextInt();
		}

		int M = in.nextInt();
		int[] arr2 = new int[M];
		for (int i = 0; i < M; i++) {
			arr2[i] = in.nextInt();
		}

		while (p1 < N && p2 < M) {
			if (arr1[p1] < arr2[p2]) {
				list.add(arr1[p1++]);
			} else {
				list.add(arr2[p2++]);
			}
		}

		while (p1 < N) {
			list.add(arr1[p1++]);
		}

		while (p2 < M) {
			list.add(arr2[p2++]);
		}


		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}
}

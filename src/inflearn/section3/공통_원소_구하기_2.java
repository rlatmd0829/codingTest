package inflearn.section3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 공통_원소_구하기_2 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int p1 = 0;
		int p2 = 0;

		List<Integer> answer = new ArrayList<>();
		int N = in.nextInt();
		int[] arr1 = new int[N];
		for (int i = 0; i < N; i++) {
			arr1[i] = in.nextInt();
		}
		Arrays.sort(arr1);

		int M = in.nextInt();
		int[] arr2 = new int[M];
		for (int i = 0; i < M; i++) {
			arr2[i] = in.nextInt();
		}
		Arrays.sort(arr2);

		while (p1 < N && p2 < M) {
			if (arr1[p1] == arr2[p2]) {
				answer.add(arr1[p1]);
				p1++;
				p2++;
			}
			else if (arr1[p1] < arr2[p2]) {
				p1++;
			} else {
				p2++;
			}
		}

		for (int i = 0; i < answer.size(); i++) {
			System.out.print(answer.get(i) + " ");
		}
	}
}

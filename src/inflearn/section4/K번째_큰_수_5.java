package inflearn.section4;

import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class K번째_큰_수_5 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int N = in.nextInt();
		int K = in.nextInt();
		int[] arr = new int[N];
		Set<Integer> set = new TreeSet<>(Collections.reverseOrder());

		for (int i = 0; i < N; i++) {
			arr[i] = in.nextInt();
		}

		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				for (int k = j+1; k < N; k++) {
					set.add(arr[i]+arr[j]+arr[k]);
				}
			}
		}
		int cnt = 1;
		boolean check = false;
		for (Integer i : set) {
			if (cnt == K) {
				check = true;
				System.out.println(i);
				break;
			}
			cnt++;
		}
		if (!check) {
			System.out.println(-1);
		}
	}
}

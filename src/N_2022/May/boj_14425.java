package N_2022.May;

import java.util.Scanner;

public class boj_14425 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int count = 0;
		String[] arr = new String[N];
		String[] check = new String[M];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.next();
		}
		for (int i = 0; i < M; i++) {
			check[i] = sc.next();
		}
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[j].equals(check[i])) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
}

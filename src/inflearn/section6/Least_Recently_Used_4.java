package inflearn.section6;

import java.util.Scanner;

public class Least_Recently_Used_4 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int S = in.nextInt();
		int N = in.nextInt();
		int[] arr = new int[N];
		int[] cache = new int[S];

		for (int i = 0; i < N; i++) {
			arr[i] = in.nextInt();
		}

		for (int x : arr) {
			int pos = -1;
			for (int i = 0; i < S; i++) {
				if (x == cache[i]) {
					pos = i;
				}
			}
			if (pos == -1) { // miss
				for (int i = S-1; i >= 1; i--) {
					cache[i] = cache[i-1];
				}
				cache[0]=x;
			} else { // hit
				for (int i = pos; i >= 1; i--) {
					cache[i] = cache[i-1];
				}
				cache[0]=x;
			}
		}
		for (int i = 0; i < S; i++) {
			System.out.print(cache[i] + " ");
		}
	}
}

package inflearn.section2;

import java.util.Scanner;

public class 소수_에라토스테네스체_5_1 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int n = in.nextInt();
		int answer = 0;
		int[] array = new int[n+1];

		for (int i = 2; i < n; i++) {
			if (array[i] == 0) {
				answer++;
				for (int j = i; j < n; j+=i) {
					array[j] = 1;
				}
			}

		}
		System.out.println(answer);
	}
}

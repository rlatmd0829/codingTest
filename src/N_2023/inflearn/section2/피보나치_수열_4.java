package N_2023.inflearn.section2;

import java.util.Scanner;

public class 피보나치_수열_4 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int n = in.nextInt();
		int[] answer = new int[n];
		answer[0] = 1;
		answer[1] = 1;
		for (int i = 2; i < n; i++) {
			answer[i] = answer[i-2] + answer[i-1];
		}

		for (int i : answer) {
			System.out.print(i + " ");
		}
	}
}

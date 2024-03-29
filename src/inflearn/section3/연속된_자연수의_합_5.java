package inflearn.section3;

import java.util.Scanner;

public class 연속된_자연수의_합_5 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int N = in.nextInt();
		int answer = 0;
		int lp = 1;
		int rp = 2;
		int sum = lp + rp;

		while (lp < N && rp < N) {
			if (sum == N) {
				answer++;
				rp++;
				sum += rp;
			} else if (sum > N) {
				sum -= lp;
				lp++;
			} else if (sum < N) {
				rp++;
				sum += rp;
			}
		}
		System.out.println(answer);
	}
}

package N_2023.inflearn.section2;

import java.util.Scanner;

public class 소수_에라토스테네스체_5 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int n = in.nextInt();
		int answer = 0;

		for (int i = 2; i < n; i++) {
			if (isPrime(i)) {
				answer++;
			}
		}
		System.out.println(answer);
	}

	public static boolean isPrime(int number) {

		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}

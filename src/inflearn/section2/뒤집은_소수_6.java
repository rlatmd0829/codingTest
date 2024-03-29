package inflearn.section2;

import java.util.Scanner;

public class 뒤집은_소수_6 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			StringBuilder s = new StringBuilder(in.next());
			int reverseNumber = Integer.parseInt(s.reverse().toString());
			if (isPrime(reverseNumber)) {
				System.out.print(reverseNumber + " ");
			}
		}
	}

	public static boolean isPrime(int number) {
		if (number == 1) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}

package inflearn.section2;

import java.util.Scanner;

public class 가위_바위_보_3 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int n = in.nextInt();
		int[] A = new int[n];
		int[] B = new int[n];

		for (int i = 0; i < n; i++) {
			A[i] = in.nextInt();
		}

		for (int i = 0; i < n; i++) {
			B[i] = in.nextInt();
		}

		for (int i = 0; i < A.length; i++) {
			if (A[i] == B[i]) {
				System.out.println("D");
			}
			else if (A[i] == 3 && B[i] == 1) {
				System.out.println("B");
			}
			else if (A[i] == 1 && B[i] == 3) {
				System.out.println("A");
			}
			else if (A[i] > B[i]) {
				System.out.println("A");
			}
			else if (A[i] < B[i]) {
				System.out.println("B");
			}
		}
	}
}

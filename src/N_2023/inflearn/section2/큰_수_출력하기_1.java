package N_2023.inflearn.section2;

import java.util.Scanner;

public class 큰_수_출력하기_1 {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int input1 = in.nextInt();

		int temp = 0;
		for (int i = 0; i < input1; i++) {
			int input2 = in.nextInt();
			if (temp == 0 || input2 > temp) {
				System.out.print(input2 + " ");
			}
			temp = input2;
		}
	}
}

package N_2023.inflearn.section2;

import java.util.Scanner;

public class 보이는_학생_2 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int input1 = in.nextInt();
		int answer = 0;

		int temp = 0;
		for (int i = 0; i < input1; i++) {
			int input2 = in.nextInt();
			if (temp < input2) {
				temp = input2;
				answer++;
			}
		}
		System.out.println(answer);
	}
}

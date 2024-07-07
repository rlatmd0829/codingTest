package N_2024.july;

import java.util.Scanner;

public class 단어_뒤집기 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int N = in.nextInt();
		String[] arr = new String[N];
		for (int i = 0; i < N; i++) {
			arr[i] = in.next();
		}

		String[] answer = new String[arr.length];
		for (int i = 0; i < arr.length; i++) {
			String temp = "";
			for (int j = arr[i].length() - 1; j >= 0; j--) {
				temp += arr[i].charAt(j);
			}
			answer[i] = temp;
		}

		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}
}

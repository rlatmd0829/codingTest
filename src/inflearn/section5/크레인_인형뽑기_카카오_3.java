package inflearn.section5;

import java.util.Scanner;
import java.util.Stack;

public class 크레인_인형뽑기_카카오_3 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int N = in.nextInt();
		int[][] arr = new int[N][N];
		Stack<Integer> stack = new Stack<>();
		int answer = 0;


		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = in.nextInt();
			}
		}

		int M = in.nextInt();
		int[] moves = new int[M];

		for (int i = 0; i < M; i++) {
			moves[i] = in.nextInt();
		}

		for (int move : moves) {
			for (int i = 0; i < N; i++) {
				if (arr[i][move-1] != 0) {
					if (!stack.isEmpty()) {
						if (stack.peek() == arr[i][move-1]) {
							stack.pop();
							answer+=2;
						} else {
							stack.push(arr[i][move-1]);
						}
					} else {
						stack.push(arr[i][move-1]);
					}
					arr[i][move-1] = 0;
					break;
				}
			}
		}
		System.out.println(answer);
	}
}

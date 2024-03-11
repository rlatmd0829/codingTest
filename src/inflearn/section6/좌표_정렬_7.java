package inflearn.section6;

import java.util.Arrays;
import java.util.Scanner;

public class 좌표_정렬_7 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int input1 = in.nextInt();
		int[][] arr = new int[input1][2];
		for (int i = 0; i < input1; i++) {
			arr[i][0] = in.nextInt();
			arr[i][1] = in.nextInt();
		}

		Arrays.sort(arr, (o1, o2) -> {
			if (o1[0] == o2[0]) {
				return o1[1] - o2[1];
			} else {
				return o1[0] - o2[0];
			}
		});

		for (int[] ints : arr) {
			System.out.println(ints[0] + " " + ints[1]);
		}
	}
}

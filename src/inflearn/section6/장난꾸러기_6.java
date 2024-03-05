package inflearn.section6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 장난꾸러기_6 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int input1 = in.nextInt();
		int[] arr = new int[input1];
		int[] temp = new int[input1];
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 0; i < input1; i++) {
			arr[i] = in.nextInt();
			temp[i] = arr[i];
		}
		Arrays.sort(temp);
		for (int i = 0; i < input1; i++) {
			if (arr[i] != temp[i]) {
				result.add(i+1);
			}
		}
		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i) + " ");
		}
	}
}

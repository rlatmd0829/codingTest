package inflearn.section2;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 등수구하기_8 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int n = in.nextInt();
		Integer[] arr = new Integer[n];
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		Integer[] init = arr.clone();
		Arrays.sort(arr, Collections.reverseOrder());
		int rank = 0;
		int temp = 0;

		for (int i = 0; i < arr.length; i++) {
			if (temp == arr[i]) {
				map.put(arr[i], map.get(arr[i-1]));
				rank += 1;
			} else {
				temp = arr[i];
				rank += 1;
				map.put(arr[i], rank);
			}
		}
		for (int i = 0; i < init.length; i++) {
			System.out.print(map.get(init[i]) + " ");
		}
	}
}

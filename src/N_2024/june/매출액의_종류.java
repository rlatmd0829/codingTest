package N_2024.june;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class 매출액의_종류 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int N = in.nextInt();
		int K = in.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = in.nextInt();
		}
		solution(N, K, arr);
	}

	public static void solution(int N, int K, int[] arr) {
		List<Integer> answer = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < K-1; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}

		int lt = 0;
		for (int rt = K-1; rt < N; rt++) {
			map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
			answer.add(map.size());
			map.put(arr[lt], map.get(arr[lt]) - 1);
			if (map.get(arr[lt]) == 0) {
				map.remove(arr[lt]);
			}
			lt++;
		}

		for (Integer i : answer) {
			System.out.print(i + " ");
		}
	}
}

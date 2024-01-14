package inflearn.section4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class 매출액의_종류_3 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int N = in.nextInt();
		int K = in.nextInt();
		int[] salesRecord = new int[N];
		List<Integer> answer = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < N; i++) {
			salesRecord[i] = in.nextInt();
		}

		int values = 0;
		for (int i = 0; i < K; i++) {
			if (!map.containsKey(salesRecord[i])) {
				map.put(salesRecord[i], 1);
				values++;
			} else {
				map.put(salesRecord[i], map.get(salesRecord[i]) + 1);
			}
		}
		answer.add(values);

		for (int i = 1; i < N-K+1; i++) {
			if (map.get(salesRecord[i-1]) == 1) {
				map.remove(salesRecord[i-1]);
				values--;
			} else {
				map.put(salesRecord[i-1], map.get(salesRecord[i-1])-1);
			}

			if (!map.containsKey(salesRecord[i+K-1])) {
				map.put(salesRecord[i+K-1], 1);
				values++;
			} else {
				map.put(salesRecord[i+K-1], map.get(salesRecord[i+K-1]) + 1);
			}
			answer.add(values);
		}

		for (Integer i : answer) {
			System.out.print(i + " ");
		}

	}
}

package N_2022.May;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class boj_1269 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		sc.nextLine();
		Set<String> resultA = new HashSet<>();
		Set<String> resultB = new HashSet<>();
		int count = 0;
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		for (int i = 0; i < A; i++) {
			String temp = st.nextToken();
			resultA.add(temp);
		}
		st = new StringTokenizer(sc.nextLine());
		for (int i = 0; i < B; i++) {
			String temp = st.nextToken();
			resultB.add(temp);
		}

		for (String s : resultA) {
			if (!resultB.contains(s)) {
				count++;
			}
		}

		for (String s : resultB) {
			if (!resultA.contains(s)) {
				count++;
			}
		}
		System.out.println(count);
	}
}

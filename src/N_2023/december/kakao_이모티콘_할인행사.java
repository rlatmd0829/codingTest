package N_2023.december;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class kakao_이모티콘_할인행사 {

	public static final List<Result> resultList = new ArrayList<>();
	public static int[] discountRates = {10, 20, 30, 40};
	public static int[][] users = new int[][]{};
	public static int[] emoticons = new int[]{};
	public static int[][] discountAmount = new int[][]{};

	public static void main(String[] args) {
		int[][] users = {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}};
		int[] emoticons = {1300, 1500, 1600, 4900};
		int[] answer = solution(users, emoticons);

		for (int i : answer) {
			System.out.print(i + " ");
		}
	}

	public static int[] solution(int[][] users, int[] emoticons) {
		kakao_이모티콘_할인행사.users = users;
		kakao_이모티콘_할인행사.emoticons = emoticons;
		discountAmount = new int[emoticons.length][4];

		for (int i = 0; i < emoticons.length; i++) {
			for (int j = 0; j < discountRates.length; j++) {
				int discount = (int)(emoticons[i] * discountRates[j] * 0.01);
				discountAmount[i][j] = (emoticons[i] - discount);
			}
		}

		permutation(new int[emoticons.length], 0);

		resultList.sort(Comparator.comparingInt((Result o) -> o.cnt)
			.thenComparingInt(o -> o.amount)
			.reversed());

		return resultList.get(0).get();
	}

	public static void permutation(int[] permutationArray, int depth) {
		if (depth == emoticons.length) {
			calculate(permutationArray);
			return;
		}
		for (int discountRate : discountRates) {
			permutationArray[depth] = discountRate;
			permutation(permutationArray, depth + 1);
		}
	}

	public static void calculate(int[] permutationArray) {
		int cnt = 0;
		int amount = 0;
		for (int[] user : users) {
			int usersRate = user[0];
			int usersTotalAmount = user[1];

			int total = 0;
			for (int j = 0; j < permutationArray.length; j++) {
				if (usersRate <= permutationArray[j]) {
					int index = permutationArray[j] / 10 - 1;
					total += discountAmount[j][index];
				}
			}

			if (usersTotalAmount <= total) {
				cnt++;
			} else {
				amount += total;
			}
		}
		resultList.add(new Result(cnt, amount));
	}

	public static class Result {
		public int cnt;
		public int amount;

		public Result(int cnt, int amount) {
			this.cnt = cnt;
			this.amount = amount;
		}

		public int[] get() {
			return new int[] {this.cnt, this.amount};
		}
	}
}

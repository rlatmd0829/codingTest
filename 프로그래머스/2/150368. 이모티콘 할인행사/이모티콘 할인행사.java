import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    public static final List<Money> list = new ArrayList<>();

	public int[] solution(int[][] users, int[] emoticons) {
		int[] answer = {};
		int[] discountRates = {10, 20, 30, 40};
		int[][] discountAmount = new int[emoticons.length][4];
		int total = 0;

		// 모든 이모티콘에 대해 10, 20, 30, 40 할인율 적용된 값 미리 계산하기
		for (int i = 0; i < emoticons.length; i++) {
			total += emoticons[i];

			for (int j = 0; j < discountRates.length; j++) {
				int discount = (int)(emoticons[i] * discountRates[j] * 0.01);
				discountAmount[i][j] = (emoticons[i] - discount);
			}
		}

		permutation(discountRates, new int[emoticons.length], 0, emoticons.length, users, discountAmount);

		list.sort(Comparator.comparingInt((Money o) -> o.cnt)
			.thenComparingInt(o -> o.amount)
			.reversed());

		return list.get(0).get();
	}

	public void permutation(
		int[] discountRates, int[] out, int depth, int r, int[][] users, int[][] discountAmount
	) {
		if (depth == r) {
			calculate(out, users, discountAmount);
			return;
		}
		for (int i = 0; i < discountRates.length; i++) {
			out[depth] = discountRates[i];
			permutation(discountRates, out, depth + 1, r, users, discountAmount);
		}
	}

	public void calculate(int[] arr, int[][] users, int[][] discountAmount) {
		int cnt = 0;
		int amount = 0;
		for (int i = 0; i < users.length; i++) {
			int total = 0;
			for (int j = 0; j < arr.length; j++) {
				if (users[i][0] <= arr[j]) {
					int index = arr[j] / 10 - 1;
					total += discountAmount[j][index];
				}
			}
			if (total >= users[i][1]) {
				cnt++;
			} else {
				amount += total;
			}
		}
		list.add(new Money(cnt, amount));
	}

	public class Money {
		public int cnt;
		public int amount;

		public Money(int cnt, int amount) {
			this.cnt = cnt;
			this.amount = amount;
		}

		public int[] get() {
			return new int[] {this.cnt, this.amount};
		}
	}
}
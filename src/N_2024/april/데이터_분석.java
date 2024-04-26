package N_2024.april;

import java.util.Arrays;
import java.util.Comparator;

public class 데이터_분석 {
	private static String[] ex = {"code", "date", "maximum", "remain"};
	public static void main(String[] args) {
		int[][] data = {{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}};
		String ext = "date";
		int val_ext = 20300501;
		String sort_by = "remain";
		int[][] result = solution(data, ext, val_ext, sort_by);
		for (int[] ints : result) {
			for (int anInt : ints) {
				System.out.print(anInt + " ");
			}
			System.out.println();
		}
	}

	public static int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {

		int keyExtIndex = 0;
		int keySortIndex = 0;

		for (int i = 0; i < ex.length; i++) {
			if (ex[i].equals(ext)) {
				keyExtIndex = i;
			}
			if (ex[i].equals(sort_by)) {
				keySortIndex = i;
			}
		}

		int finalExtKeyIndex = keyExtIndex;
		int[][] filteredArray = Arrays.stream(data)
			.filter(a -> a[finalExtKeyIndex] < val_ext)
			.toArray(int[][]::new);


		int finalSortKeyIndex = keySortIndex;
		Arrays.sort(filteredArray, Comparator.comparingInt(a -> a[finalSortKeyIndex]));

		return filteredArray;
	}
}

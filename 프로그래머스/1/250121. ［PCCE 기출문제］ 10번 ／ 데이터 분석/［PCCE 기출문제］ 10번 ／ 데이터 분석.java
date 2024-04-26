import java.util.Arrays;

class Solution {
    public String[] ex = {"code", "date", "maximum", "remain"};
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {

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
		Arrays.sort(filteredArray, (a,b) -> Integer.compare(a[finalSortKeyIndex], b[finalSortKeyIndex]));

		return filteredArray;
	}
}
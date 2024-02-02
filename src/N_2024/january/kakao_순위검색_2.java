package N_2024.january;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class kakao_순위검색_2 {
	public static void main(String[] args) {
		String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		List<Integer> answer = solution(info, query);
		System.out.println(Arrays.toString(answer.toArray()));
	}

	public static List<Integer> solution(String[] info, String[] query) {
		List<Integer> answer = new ArrayList<>();

		String[][] infoString = new String[info.length-1][2];

		for (int i = 0; i < info.length; i++) {
			int lastSpaceIndex = info[i].lastIndexOf(' ');
			infoString[i][0] = info[i].substring(0, lastSpaceIndex);
			infoString[i][1] = info[i].substring(lastSpaceIndex + 1);
		}

		Arrays.sort(infoString, Comparator.comparingInt(a -> Integer.parseInt(a[1])));

		for (String[] strings : infoString) {
			System.out.println(Arrays.toString(strings));
		}

		for (int i = 0; i < query.length; i++) {
			int mid = (info.length-1) / 2;

			int lastSpaceIndex = info[i].lastIndexOf(' ');
			String leftQueryString = query[i].substring(0, lastSpaceIndex);
			String rightQueryString = query[i].substring(lastSpaceIndex + 1);

			int lt = 0;
			int rt = info.length-1;
			for (int j = 0; j < infoString.length; j++) {
				if (Integer.parseInt(infoString[mid][1]) > Integer.parseInt(rightQueryString)) {
					rt = mid - 1;
					mid = lt + rt / 2;
				}
			}
		}

		//포기


		return answer;
	}
}

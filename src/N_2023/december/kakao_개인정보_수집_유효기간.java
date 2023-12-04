package N_2023.december;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class kakao_개인정보_수집_유효기간 {
	public static void main(String[] args) {
		String today = "2022.05.19";
		String[] terms = {"A 6", "B 12", "C 3"};
		String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
		List<Integer> answer = solution(today, terms, privacies);
		for (int i : answer) {
			System.out.print(i + " ");
		}
	}

	public static List<Integer> solution(String today, String[] terms, String[] privacies) {
		List<Integer> answer = new ArrayList<>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
		LocalDate todayDate = LocalDate.parse(today, formatter);

		Map<String, Integer> map = new HashMap<>();

		for (String term : terms) {
			String[] termArray = term.split(" ");
			map.put(termArray[0], Integer.parseInt(termArray[1]));
		}

		for (int i = 0; i < privacies.length; i++) {
			String[] privacyArray = privacies[i].split(" ");

			int value = map.get(privacyArray[1]);

			LocalDate expirationDate = LocalDate.parse(privacyArray[0], formatter);
			expirationDate = expirationDate.plusMonths(value).minusDays(1);

			if (expirationDate.isBefore(todayDate)) {
				answer.add(i+1);
			}
		}
		return answer;
	}
}

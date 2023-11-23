import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
		List<Integer> answer = new ArrayList<>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
		LocalDate todayLocalDate = LocalDate.parse(today, formatter);

		Map<String, Integer> map = new HashMap<>();

		for (String term : terms) {
			String[] termArray = term.split(" ");
			map.put(termArray[0], Integer.parseInt(termArray[1]));
		}

		for (int i = 0; i < privacies.length; i++) {
			String[] privacyArray = privacies[i].split(" ");

			int value = map.get(privacyArray[1]);
			
			LocalDate localDate = LocalDate.parse(privacyArray[0], formatter);
			localDate = localDate.plusMonths(value).minusDays(1);
			
			if (localDate.isBefore(todayLocalDate)) {
				answer.add(i+1);
			}
		}
		return answer;
	}
}
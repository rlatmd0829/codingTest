package N_2023.december;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class kakao_주차_요금_계산 {

	public static void main(String[] args) {
		// 기본시간 180분
		// 기본 요금 5000원
		// 단위 시간 10분
		// 단위 요금 600
		int[] fees = {180, 5000, 10, 600};
		String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
		List<Integer> result = solution(fees, records);

		for (Integer i : result) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static List<Integer> solution(int[] fees, String[] records) {
		List<Integer> answer = new ArrayList<>();

		int basicTime = fees[0];
		int basicAmount = fees[1];
		int unitTime = fees[2];
		int unitAmount = fees[3];
		int lastTimeMin = 23 * 60 + 59;

		Map<Integer, String> map = new HashMap<>(); // carNumber, time
		Map<Integer, Integer> totalTimeMap = new HashMap<>(); // carNumber, remainMin

		for (String record : records) {
			String[] split = record.split(" ");
			String time = split[0];
			Integer carNumber = Integer.valueOf(split[1]);
			String status = split[2];
			if (status.equals("IN")) {
				map.put(carNumber, time);
			} else {
				String inTime = map.get(carNumber);
				Integer inTimeMin = getMinute(inTime);
				Integer outTimeMin = getMinute(time);

				Integer remainMin = outTimeMin - inTimeMin;

				// resultMap에 존재한다면 이미 계산한 금액이 존재하므로 누적으로 쌓는다.
				totalTimeMap.merge(carNumber, remainMin, Integer::sum);
				map.remove(carNumber);
			}
		}

		// map에 남아있는게 있다면 "OUT"을 안한 차량이다.
		for (Integer number : map.keySet()) {
			String time = map.get(number);
			Integer inTimeMin = getMinute(time);

			Integer remainMin = lastTimeMin - inTimeMin;

			totalTimeMap.merge(number, remainMin, Integer::sum);
		}

		List<Integer> carNumbers = new ArrayList<>(totalTimeMap.keySet());
		Collections.sort(carNumbers);

		// 주차시간으로 요금계산
		for (Integer carNumber : carNumbers) {
			int parkingTime = totalTimeMap.get(carNumber);

			if (parkingTime <= basicTime) {
				answer.add(basicAmount);
			} else {
				int totalAmount = 0;

				parkingTime -= basicTime;
				totalAmount += basicAmount;

				int unit = parkingTime / unitTime;
				int remainTime = parkingTime % unitTime;

				totalAmount += unit * unitAmount;

				// 올림처리
				if (remainTime > 0) {
					totalAmount += unitAmount;
				}
				answer.add(totalAmount);
			}
		}

		return answer;
	}

	private static Integer getMinute(String inTime) {
		String[] timeMins = inTime.split(":");
		return Integer.parseInt(timeMins[0]) * 60 + Integer.parseInt(timeMins[1]);
	}
}

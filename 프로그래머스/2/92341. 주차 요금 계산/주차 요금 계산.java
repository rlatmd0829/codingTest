import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> solution(int[] fees, String[] records) {
		List<Integer> answer = new ArrayList<>();

		int basicTime = fees[0];
		int basicAmount = fees[1];
		int unitTime = fees[2];
		int unitAmount = fees[3];
		int lastTimeMin = 23 * 60 + 59;

		Map<Integer, String> map = new HashMap<>();
		Map<Integer, Integer> resultMap = new HashMap<>();

		for (String record : records) {
			String[] split = record.split(" ");
			String time = split[0];
			Integer number = Integer.valueOf(split[1]);
			String parking = split[2];
			if (parking.equals("IN")) {
				map.put(number, time);
			} else {
				String inTime = map.get(number);
				String[] inTimeMins = inTime.split(":");
				String[] outTimeMins = time.split(":");
				Integer inTimeMin = Integer.valueOf(inTimeMins[0]) * 60 + Integer.valueOf(inTimeMins[1]);
				Integer outTimeMin = Integer.valueOf(outTimeMins[0]) * 60 + Integer.valueOf(outTimeMins[1]);

				Integer remainMin = outTimeMin - inTimeMin;

				if (resultMap.get(number) == null) {
					resultMap.put(number, remainMin);
				} else {
					resultMap.put(number, resultMap.get(number) + remainMin);
				}
				map.remove(number);
			}
		}

		for (Integer number : map.keySet()) {
			String inTime = map.get(number);
			String[] inTimeMins = inTime.split(":");
			Integer inTimeMin = Integer.valueOf(inTimeMins[0]) * 60 + Integer.valueOf(inTimeMins[1]);

			Integer remainMin = lastTimeMin - inTimeMin;

			if (resultMap.get(number) == null) {
				resultMap.put(number, remainMin);
			} else {
				resultMap.put(number, resultMap.get(number) + remainMin);
			}
		}

		List<Integer> carNumbers = new ArrayList<>(resultMap.keySet());

		Collections.sort(carNumbers);

		for (Integer carNumber : carNumbers) {
			int parkingTime = resultMap.get(carNumber);

			if (parkingTime <= basicTime) {
				answer.add(basicAmount);
			} else {
				int totalAmount = 0;

				parkingTime -= basicTime;
				totalAmount += basicAmount;

				int unit = parkingTime / unitTime;
				int remainTime = parkingTime % unitTime;

				totalAmount += unit * unitAmount;

				if (remainTime > 0) {
					totalAmount += unitAmount;
				}
				answer.add(totalAmount);
			}
		}

		return answer;
	}
}
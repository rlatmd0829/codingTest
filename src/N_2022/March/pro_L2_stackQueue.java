package N_2022.March;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class pro_L2_stackQueue {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1}).toString());
    }

    public static List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();

        List<Integer> progressesList = Arrays.stream(progresses)
                .boxed()
                .collect(Collectors.toList());

        List<Integer> speedsList = Arrays.stream(speeds)
                .boxed()
                .collect(Collectors.toList());

        while (!progressesList.isEmpty()) {
            int count = 0;
            while (progressesList.get(0) >= 100) {
                progressesList.remove(0);
                speedsList.remove(0);
                count ++;
                if (progressesList.isEmpty()) {
                    break;
                }
            }
            if (count >= 1) {
                answer.add(count);
            }
            for (int i = 0; i < progressesList.size(); i++) {
                progressesList.set(i, progressesList.get(i) + speedsList.get(i));
            }
        }

        return answer;
    }
}

package N_2022.March;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class pro_L1_addMissingNumbers {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,3,4,6,7,8,0}));
    }

    private static int solution(int[] numbers) {
        int answer = 0;

        // primitive type인 경우 Arrays.asList()를 사용하면 List<int[]> 타입이 된다.

        // primitive 타입을 Wrapper 클래스로(여기서는 int에서 Integer로) 형변환해주지 않기 때문에,
        // primitive 타입의 배열은, Arrays.asList()로는 List로 변환할 수 없습니다.

        // 따라서 Arrays.asList()를 사용하지말고 그냥 새로 리스트를 만들어서 add시켜주거나
        // Stream을 이용해 Wrapper Class로 바꿔주고 넣는 방법이있다.

        List<Integer> list = Arrays.stream(numbers)
                .boxed()
                .collect(Collectors.toList());

        for (int i = 0; i < 10; i++) {
            if (!list.contains(i)) {
                answer += i;
            }
        }

        return answer;
    }
}

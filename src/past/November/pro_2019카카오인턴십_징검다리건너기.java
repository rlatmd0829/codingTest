package past.November;

public class pro_2019카카오인턴십_징검다리건너기 {
    public static int solution(int[] stones, int k){
        int answer = 0;
        Loop1 :
        while(true){

            for (int i = 0; i < stones.length; i++) {

                if (stones[i] == 0){
                    int count = 1;

                    for (int j = i; j < stones.length; j++) {
                        if (count > k){
                            break Loop1;
                        }
                        if (stones[j] != 0){
                            break;
                        }
                        count += 1;

                    }
                    if (count > k){ // 마지막 부분도 통과하는지
                        break Loop1;
                    }
                }
                else {
                    stones[i] -= 1;
                }

            }
            answer += 1;

        }

        return answer;
    }

    public static void main(String[] args) {
        int[] stones = {2,4,5,3,2,1,4,2,5,1};
        int k = 3;
        System.out.println(solution(stones, k));
    }
}

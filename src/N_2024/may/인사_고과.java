package N_2024.may;

public class 인사_고과 {
    public static void main(String[] args) {
        int[][] scores = {{7,1}, {6,6}, {5,4}, {5,4}, {6,6}};
        int result = solution(scores);
        System.out.println(result);
    }

    public static int solution(int[][] scores) {
        int answer = 1;

        int[] wanho = scores[0];
        int sum = wanho[0] + wanho[1];

        for (int i = 1; i < scores.length; i++) {
            if (wanho[0] < scores[i][0] && wanho[1] < scores[i][1]) {
                return -1;
            }

            if (sum < scores[i][0] + scores[i][1]) {
                // 2중 포문은 완호보다 높은점수를 가진 사람중에 인센티브를 받지 못해 등수에서 제외되는 사람이 있는지 확인
                if (check(scores, i, sum, answer)) {
                    answer++;
                }
            }
        }
        return answer;
    }

    private static boolean check(int[][] scores, int i, int sum, int answer) {
        for (int j = 1; j < scores.length; j++) {
            if (i == j) {
                continue;
            }
            if (scores[i][0] < scores[j][0] && scores[i][1] < scores[j][1]) {
                if (sum < scores[i][0] + scores[i][1]) {
                    return false;
                }
                break;
            }
        }
        return true;
    }


}

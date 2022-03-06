package N_2022.March;

public class pro_L2_targetNumber {

    static int answer;

    public static void main(String[] args) {
        solution(new int[]{4,1,2,1}, 4);
    }

    private static void solution(int[] numbers, int target) {
        dfs(numbers,0, target, 0);
        System.out.println(answer);
    }

    private static void dfs(int[] numbers, int count, int target, int now) {
        if (now == target && count == numbers.length) {
            answer += 1;
            return;
        }
        if (count == numbers.length) {
            return;
        }
        dfs(numbers, count+1, target, now + numbers[count]);
        dfs(numbers, count+1, target, now - numbers[count]);
    }
}

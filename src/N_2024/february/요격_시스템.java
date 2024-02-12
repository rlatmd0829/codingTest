package N_2024.february;

import java.util.Arrays;

public class 요격_시스템 {
	public static void main(String[] args) {
		int[][] targets = {{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}};
		int answer = solution(targets);
		System.out.println(answer);
	}
	public static int solution(int[][] targets) {
		int answer = 0;

		Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);

		for (int[] target : targets) {
			System.out.println(Arrays.toString(target));
		}

		int before = 0;
		for(int i=0;i<targets.length;i++){
			if(before <= targets[i][0]){
				before = targets[i][1];
				answer++;
			}
		}

		return answer;
	}
}

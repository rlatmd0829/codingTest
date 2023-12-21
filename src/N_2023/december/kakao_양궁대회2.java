package N_2023.december;

class kakao_양궁대회2 {
	static int N;
	static int cnt = 10;
	static int maxScore = Integer.MIN_VALUE;
	static int answer[] = new int[11];
	static boolean[] visited = new boolean[11];

	public static void main(String[] args) {
		// int n = 5;
		// int[] info = {2,1,1,1,0,0,0,0,0,0,0};
		// [0,2,2,0,1,0,0,0,0,0,0]

		int n = 9;
		int[] info = {0,0,1,2,0,1,1,1,1,1,1};
		// 	[1,1,2,0,1,2,2,0,0,0,0]
		solution(n, info);
	}

	public static int[] solution(int n, int[] info) {
		int arr[] = new int[11];
		N = n;
		dfs(arr, 0, info);

		if(maxScore==Integer.MIN_VALUE) {
			return new int[] {-1};
		}

		return answer;
	}

	public static int[] dfs(int[] arr, int depth, int[] info) {

		if (depth == N) {
			score(arr, info);
			return arr;
		}


		for (int i = 0; i < arr.length && arr[i] <= info[i] && arr[i] <= N; i++) {
			if(!visited[i]) {
				arr[i] += 1;
				visited[i] = true;
				dfs(arr, depth + 1, info);
				arr[i] -= 1;
				depth -= 1;
				visited[i] = false;
			}
		}

		return arr;
	}

	public static void score(int[] lionScore, int[] info) {
		int lion = 0;
		int apeach = 0;

		for (int i = 0; i < lionScore.length; i++) {
			if (lionScore[i] > info[i]) {
				lion += 10 - i;
			} else if(info[i] != 0){
				apeach += 10 - i;
			}
		}

		if (lion - apeach > 0 && maxScore <= lion - apeach) {
			maxScore = Math.max(maxScore, lion - apeach);
			answer = lionScore.clone();
		}
	}
}

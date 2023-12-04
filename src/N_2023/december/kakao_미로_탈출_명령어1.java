package N_2023.december;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class kakao_미로_탈출_명령어1 {


	public static void main(String[] args) {
		int n = 2;
		int m = 2;
		int x = 1;
		int y = 1;
		int r = 2;
		int c = 2;
		int k = 2;
		// dr

		// int n = 3;
		// int m = 3;
		// int x = 1;
		// int y = 2;
		// int r = 3;
		// int c = 3;
		// int k = 4;
		// impossible

		// int n = 3;
		// int m = 4;
		// int x = 2;
		// int y = 3;
		// int r = 3;
		// int c = 1;
		// int k = 5;
		// dllrl

		// int n = 6;
		// int m = 6;
		// int x = 2;
		// int y = 6;
		// int r = 6;
		// int c = 5;
		// int k = 11;
		// ddddllllrrr
		System.out.println(solution(n, m, x, y, r, c, k));
	}

	public static String solution(int n, int m, int x, int y, int r, int c, int k) {

		// 위, 아래, 왼, 오
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		String[] dc = {"u", "d", "l", "r"};
		List<String> resultList = new ArrayList<>();

		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(x, y, ""));

		while (!queue.isEmpty()) {
			Node node = queue.remove();
			for (int i = 0; i < 4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				if (0 < nx && 0 < ny && nx <= n && ny <= m) {
					String result = node.result + dc[i];
					if (node.result.length() < k) {
						queue.add(new Node(nx, ny, result)); // 상하좌우 이동하고 result에는 문자열 추가해서 queue를 계속돌아준다.
					}
					if (nx == r && ny == c && k == result.length()) { // 목적지에 도착했을때 K와 길이가 같다면 list에 추가한다.
						resultList.add(result);
					}
				}
			}
		}
		if (resultList.isEmpty()) {
			return "impossible";
		}
		Collections.sort(resultList);
		return resultList.get(0);
	}

	public static class Node {
		int x;
		int y;
		String result;

		public Node(int x, int y, String result) {
			this.x = x;
			this.y = y;
			this.result = result;
		}
	}
}


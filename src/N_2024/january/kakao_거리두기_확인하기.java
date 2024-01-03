package N_2024.january;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class kakao_거리두기_확인하기 {

	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) {
		// String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
		// 	{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {
		// 	"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {
		// 	"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};

		String[][] places = {{"POOOO", "XPOOO", "OOOOO", "OOOOO", "OOOOO"}, {"OOOOO", "OOOOO", "OOOOO", "OOOOO", "OOOOO"}, {
		"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {
		"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};

		List<Integer> answer = solution(places);
		System.out.println(Arrays.toString(answer.toArray()));
	}

	public static List<Integer> solution(String[][] places) {
		List<Integer> answer = new ArrayList<>();
		char[][] chars = new char[5][5];

		for (int i = 0; i < places.length; i++) {
			for (int j = 0; j < places[i].length; j++) {
				chars[j] = places[i][j].toCharArray();
			}
			int cnt = 0;
			loop:
			for (int j = 0; j < places[i].length; j++) {
				for (int k = 0; k < chars[j].length; k++) {
					if (chars[j][k] == 'P') {
						boolean check = bfs(chars, j, k);
						if (!check) {
							break loop;
						}
					}
					cnt++;
				}
			}

			if (cnt == 25) {
				answer.add(1);
			} else {
				answer.add(0);
			}
		}

		return answer;
	}

	public static boolean bfs(char[][] chars, int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x, y});

		while (!queue.isEmpty()) {
			int q[] = queue.poll();
			int qx = q[0];
			int qy = q[1];

			for (int i = 0; i < dx.length; i++) {
				int nx = qx + dx[i];
				int ny = qy + dy[i];

				if (nx >= 0 && ny >= 0 && nx < 5 && ny < 5) {
					if (chars[nx][ny] == 'P') {
						return false;
					}
					if (chars[nx][ny] == 'O') {
						for (int j = 0; j < dx.length; j++) {
							int nnx = nx + dx[j];
							int nny = ny + dy[j];

							if (nnx >= 0 && nny >= 0 && nnx < 5 && nny < 5) {
								if (nnx == qx && nny == qy) {
									continue;
								}
								if (chars[nnx][nny] == 'P') {
									return false;
								}
							}
						}
					}
				}
			}
		}
		return true;
	}
}

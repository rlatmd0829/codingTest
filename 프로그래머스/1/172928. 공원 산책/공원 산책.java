import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(String[] park, String[] routes) {
		int[] answer = {};

		String[][] arr = new String[park.length][park[0].length()];
		String[][] next = new String[routes.length][2];

		for (int i = 0; i < park.length; i++) {
			arr[i] = park[i].split("");
		}

		for (int i = 0; i < routes.length; i++) {
			next[i] = routes[i].split(" ");
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j].equals("S")) {
					answer = bfs(i,j, arr, next);
				}
			}

		}

		return answer;
	}

	public int[] bfs(int x, int y, String[][] arr, String[][] next) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(x, y, next[0][0], Integer.parseInt(next[0][1])));
		int answerX = x;
		int answerY = y;
		int cnt = 0;

		while (!queue.isEmpty()) {
			Node q = queue.poll();
			int qx = q.x;
			int qy = q.y;
			boolean step = false;

			if (qx < 0 || qy < 0 || qx >= arr.length || qy >= arr[0].length){
				qx = q.x;
				qy = q.y;
			}

			if ("E".equals(q.direction)) {
				if (qy + q.distance >= arr[0].length) {

				} else {
					for (int j = 1; j <= q.distance; j++) {
						if (arr[qx][qy+j].equals("X")) {
							step = true;
						}
					}
					if (!step) {
						qy += q.distance;
					}
				}

			} else if ("W".equals(q.direction)) {
				if (qy - q.distance < 0) {

				} else {
					for (int j = 1; j <= q.distance; j++) {
						if (arr[qx][qy-j].equals("X")) {
							step = true;
						}
					}
					if (!step) {
						qy -= q.distance;
					}
				}

			} else if ("N".equals(q.direction)) {
				if (qx - q.distance < 0) {

				} else {
					for (int j = 1; j <= q.distance; j++) {
						if (arr[qx-j][qy].equals("X")) {
							step = true;
						}
					}
					if (!step) {
						qx -= q.distance;
					}
				}

			} else if ("S".equals(q.direction)) {
				if (qx + q.distance >= arr.length) {

				} else {
					for (int j = 1; j <= q.distance; j++) {
						if (arr[qx+j][qy].equals("X")) {
							step = true;
						}
					}
					if (!step) {
						qx += q.distance;
					}
				}

			}

			cnt++;
			answerX = qx;
			answerY = qy;
			if (next.length == cnt) {
				return new int[]{answerX, answerY};
			}
			queue.add(new Node(qx, qy, next[cnt][0], Integer.parseInt(next[cnt][1])));

		}
		return new int[]{answerX, answerY};
	}

	public class Node {
		int x;
		int y;
		String direction;
		int distance;

		public Node(int x, int y, String direction, int distance) {
			this.x = x;
			this.y = y;
			this.direction = direction;
			this.distance = distance;
		}
	}
}
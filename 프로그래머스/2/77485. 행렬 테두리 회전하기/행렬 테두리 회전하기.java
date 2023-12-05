import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

class Solution {

	public List<Integer> solution(int rows, int columns, int[][] queries) {
		List<Integer> answer = new ArrayList<>();

		int[][] array = new int[rows+1][columns+1];

		int val = 1;

		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= columns; j++) {
				array[i][j] = val;
				System.out.print(val + " ");
				val++;
			}
			System.out.println();
		}

		for (int[] query : queries) {
			int x1 = query[0];
			int y1 = query[1];
			int x2 = query[2];
			int y2 = query[3];
			int minn = Integer.MAX_VALUE;

			Map<Node, Integer> map = new HashMap<>();

			for (int i = x1; i <= x2; i++) {
				for (int j = y1; j <= y2; j++) {
					if (i == x1 || j == y1 || i == x2 || j == y2) {
						map.put(new Node(i, j), array[i][j]);
						minn = Math.min(minn, array[i][j]);
					}
				}
			}
			answer.add(minn);

			for (Node node : map.keySet()) {
				int x = node.x;
				int y = node.y;
				// x == x1 랑 같으면 왼쪽껄 가져온다. 왼쪽이 범위 벗어나면 가져오지 x
				if (x == x1) {
					if (y != y1) {
						array[x][y] = map.get(new Node(x, y-1));
					}
				}

				// y == y2 랑 같으면 위에껄 가져온다. 위에가 범위 벗어나면 가져오지 x
				if (y == y2) {
					if (x != x1) {
						array[x][y] = map.get(new Node(x-1, y));
					}
				}

				// x == x2 랑 같으면 오른쪽껄 가져온다. 오른쪽이 범위 벗어나면 가져오지 x
				if (x == x2) {
					if (y != y2) {
						array[x][y] = map.get(new Node(x, y+1));
					}
				}

				// y == y1 랑 같으면 아래껄 가져온다. 아래가 범위 벗어나면 가져오지 x
				if (y == y1) {
					if (x != x2) {
						array[x][y] = map.get(new Node(x+1, y));
					}
				}
			}

			// for (int i = 1; i <= rows; i++) {
			// 	for (int j = 1; j <= columns; j++) {
			// 		System.out.print(array[i][j] + " ");
			// 	}
			// 	System.out.println();
			// }
			// System.out.println("==============");
		}

		return answer;
	}

	public class Node {
		public int x;
		public int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			Node node = (Node)o;
			return x == node.x && y == node.y;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}
	}
}
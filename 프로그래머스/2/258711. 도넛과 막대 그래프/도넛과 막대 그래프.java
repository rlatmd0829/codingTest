import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited = new boolean[1000000];

	public List<Integer> solution(int[][] edges) {
		List<Integer> answer = new ArrayList<>();
		graph=new ArrayList<>();

		for (int i = 0; i < 1000000; i++) {
			graph.add(new ArrayList<>());
		}

		for (int[] edge : edges) {
			graph.get(edge[0]).add(edge[1]);
		}

		int maxx = 0;
		int index = 0;

		int[] count = new int[1000000];

		// edge[0]이 가장 많은 노드를 정점으로 취급하자
		for (int[] edge : edges) {
			count[edge[0]]++;
			if (count[edge[0]] > maxx) {
				maxx = count[edge[0]];
				index = edge[0];
			}
		}

		List<Integer> start = new ArrayList<>();

		// 정점에서 연결된 값들을 구한다
		for (int[] edge : edges) {
			if (index == edge[0]) {
				start.add(edge[1]);
			}
		}

		int donut = 0;
		int stick = 0;
		int eight = 0;

		for (Integer i : start) {
			Node node = bfs(i);

			// 도넛 모양 그래프 : 크기가 n이면 n개의 정점과 n개의 간선
			// 막대 모양 그래프 : 크기가 n이면 n개의 정점과 n-1개의 간선
			// 8자 모양 그래프 : 크기가 n이면 2n+1개의 정점과 2n+2개의 간선이 있다.

			if (node.vertex == node.line) {
				donut++;
			}
			if (node.vertex > node.line) {
				stick++;
			}
			if (node.vertex < node.line) {
				eight++;
			}
		}
		answer.add(index);
		answer.add(donut);
		answer.add(stick);
		answer.add(eight);

		return answer;
	}

	public Node bfs(int V) {
		Queue<Integer> queue = new LinkedList<>();
		int vertex = 0;
		int line = 0;

		queue.add(V);
		visited[V] = true;

		while (!queue.isEmpty()) {
			int temp = queue.poll();
			vertex++;

			for (Integer i : graph.get(temp)) {
				line++;
				if (!visited[i]) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}
		return new Node(vertex, line);
	}

	public class Node {
		int vertex;
		int line;

		public Node(int vertex, int line) {
			this.vertex = vertex;
			this.line = line;
		}
	}
}
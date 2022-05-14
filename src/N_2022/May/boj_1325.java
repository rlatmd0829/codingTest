package N_2022.May;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1325 {
    static int N;
    static int M;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int[] distance;
    static int maxx = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        list = new ArrayList[N+1];
        for (int i = 1; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }
        distance = new int[N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
        }
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N+1];
            bfs(i);
        }
        for (int i = 1; i < N+1; i++) {
            maxx = Math.max(maxx, distance[i]);
        }
        for (int i = 1; i < N+1; i++) {
            if (distance[i] == maxx) {
                sb.append(i+" ");
            }
        }
        System.out.println(sb.toString());
    }
    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            Integer now = queue.remove();
            for (Integer i : list[now]) {
                if (!visited[i]) {
                    queue.add(i);
                    distance[i]++;
                    visited[i] = true;
                }
            }
        }
    }
}

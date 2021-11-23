package November;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_11724_연결요소의개수 {
    static int N;
    static int M;
    static int[][] arr;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N][N];
        visited = new boolean[N];
        int count = 0;

        for (int i = 0; i < M; i++) {
           int a = sc.nextInt();
           int b = sc.nextInt();
           arr[a-1][b-1] = arr[b-1][a-1] = 1;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                bfs(i);
                count++;
            }

        }
        System.out.println(count);
    }
    public static void bfs(int V){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(V);
        visited[V] = true;

        while (!queue.isEmpty()){
            int temp = queue.poll();
            for (int i = 0; i < arr.length; i++) {
                if (arr[temp][i] == 1 && visited[i] == false) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}

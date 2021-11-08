package November;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_2606_바이러스 {
    static int[][] arr;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        arr = new int[N+1][N+1];
        visited = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = arr[b][a] = 1;
        }

        System.out.println(bfs(1));


    }
    public static int bfs(int V){
        int local_count = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);
        visited[V] = true;

        while (!queue.isEmpty()){
            int temp = queue.poll();
            for (int i = 0; i < arr.length; i++) {
                if (arr[temp][i] == 1 && visited[i] == false){
                    queue.add(i);
                    visited[i] = true;
                    local_count++;
                }
            }
        }
        return local_count;
    }
}

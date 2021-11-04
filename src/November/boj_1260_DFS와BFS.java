package November;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_1260_DFS와BFS {
    public static int[][] arr;
    public static boolean[] visited;

    // 인접행렬 풀이

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt(); // 간선의 수
        int V = sc.nextInt();

        arr = new int[N+1][N+1]; // n으로 이중배열 선언

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = arr[b][a] = 1;
        }
//      행렬 보기
//        for (int i = 1; i < arr.length; i++) {
//            for (int j = 0; j < arr.length; j++) {
//                System.out.print(arr[i][j]);
//            }
//            System.out.println();
//
//        }

        visited = new boolean[N+1];
        dfs(V);
        System.out.println();

        visited = new boolean[N+1];
        bfs(V);

    }

    public static void dfs(int V){
        visited[V] = true;
        System.out.print(V + " ");

        if(V == arr.length){
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[V][i] == 1 && visited[i] == false){
                dfs(i);
            }
        }
    }

    public static void bfs(int V){
        Queue<Integer> que = new LinkedList<Integer>();

        que.add(V);
        visited[V] = true;
        System.out.print(V + " ");

        while (!que.isEmpty()){
            int temp = que.peek();
            que.poll();
            for (int i = 1; i < arr.length; i++) {
                if(arr[temp][i] == 1 && visited[i] == false){
                    que.add(i);
                    visited[i] = true;
                    System.out.print(i + " ");
                }

            }
        }
    }
}

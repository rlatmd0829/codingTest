package N_2022.April;

import java.util.ArrayList;
import java.util.List;

public class pro_home_1 {
    static List<Node> result = new ArrayList<>();
    static List<String> answer = new ArrayList<>();
    static char[] direction = {'E', 'S', 'W', 'N'}; // 동 남 서 북

    static class Node{
        int cnt;
        String dir;

        public Node(int cnt, String dir) {
            this.cnt = cnt;
            this.dir = dir;
        }
    }

    public static void main(String[] args) {
        solution("SSSSSSWWWNNNNNN");

    }

    private static void solution(String path) {
        char[] c = path.toCharArray();
        char start = c[0];
        int count = 1;
        for (int i = 1; i < c.length; i++) {
            if (c[i] == start) {
                count++;
            } else {
                make(count, c[i], start);
                count = 1;
                start = c[i];
            }
        }
        int time = 0;
        for (int i = 0; i < result.size(); i++) {
            int temp;
            if (result.get(i).cnt > 5) {
                temp = result.get(i).cnt - 5;
                time += temp;
                answer.add("Time " + time + ": Go straight " + 5 * 100 + "m and turn " + result.get(i).dir);
                time += result.get(i).cnt - temp;
            } else {
                answer.add("Time " + time + ": Go straight " + result.get(i).cnt * 100 + "m and turn " + result.get(i).dir);
                time += result.get(i).cnt;
            }
        }

        System.out.println(answer.toString());
    }

    private static void make(int count, char now, char pre) {
        int p = 0;
        int n = 0;
        for (int i = 0; i < 4; i++) {
            if (pre == direction[i]) {
                p = i;
            }
            if (now == direction[i]) {
                n = i;
//                result.add(new Node(count, i));
            }
        }
        if (p > n) {
            if (p == 3 && n == 0) {
                result.add(new Node(count, "right"));
            } else {
                result.add(new Node(count, "left"));
            }
        } else {
            if (n == 3 && p == 0) {
                result.add(new Node(count, "left"));
            } else {
                result.add(new Node(count, "right"));
            }
        }
    }
}

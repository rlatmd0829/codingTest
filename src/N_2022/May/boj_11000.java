package N_2022.May;

import java.util.*;
import java.util.stream.Collectors;

public class boj_11000 {
    public static class Node {
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Node> nodeList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            nodeList.add(new Node(a, b));
        }
        List<Node> collect = nodeList.stream()
                .sorted(Comparator.comparing(Node::getStart).thenComparing(Node::getEnd))
                .collect(Collectors.toList());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(collect.get(0).end);
        for (int i = 1; i < collect.size(); i++) {
            if (collect.get(i).start >= pq.peek()) {
                pq.poll();
            }
            pq.offer(collect.get(i).end);
        }
        System.out.println(pq.size());



    }


}

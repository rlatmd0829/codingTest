package past.October;

import java.util.Stack;

class pro_2021카카오_표편집 {
    public static int[] arr;

    public static class Node {
        Node left;
        Node right;
        int nodeNum; // 행번호
    }

    public static class DoubleLinkedList {
        // 문제의 연산을 편리하게 하기 위한 head, tail
        Node head;
        Node tail;

        public void init(int N) {
            if (head == null) {
                head = new Node();
                tail = new Node();
                head.right = tail;
                tail.left = head;
            }
            for (int i = 0; i < N; i++) {
                insert(i);
            }
        }

        public void insert(int num) {
            Node cur = new Node();
            cur.nodeNum = num;
            cur.right = tail;
            cur.left = tail.left;
            tail.left.right = cur;
            tail.left = cur;
        }

        public void delete(Node deleteNode) {
            deleteNode.right.left = deleteNode.left;
            deleteNode.left.right = deleteNode.right;
        }
    }

    public static String solution(int n, int k, String[] cmd) {
        arr = new int[n + 1];
        StringBuilder ans = new StringBuilder();
        Stack<Node> deleteNode = new Stack<Node>();
        DoubleLinkedList list = new DoubleLinkedList();
        list.init(n);

        Node pointer = list.head.right;
        for (int i = 0; i < k; i++) {
            pointer = pointer.right;
        }

        for (int i = 0; i < cmd.length; i++) {
            String query = cmd[i];
            if (query.charAt(0) == 'U') {
                int cnt = Integer.parseInt(query.substring(2));
                for (int j = 0; j < cnt; j++) {
                    pointer = pointer.left;
                }
            } else if (query.charAt(0) == 'D') {
                int cnt = Integer.parseInt(query.substring(2));
                for (int j = 0; j < cnt; j++) {
                    pointer = pointer.right;
                }
            } else if (query.charAt(0) == 'C') {
                arr[pointer.nodeNum] = 1;
                deleteNode.push(pointer);
                list.delete(pointer);
                if (pointer.right == list.tail) {
                    pointer = pointer.left;
                } else {
                    pointer = pointer.right;
                }
            } else if (query.charAt(0) == 'Z') {
                Node restoration = deleteNode.pop();
                arr[restoration.nodeNum] = 0;
                restoration.right.left = restoration;
                restoration.left.right = restoration;
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                ans.append("O");
            } else {
                ans.append("X");
            }
        }
        return ans.toString();
    }
}

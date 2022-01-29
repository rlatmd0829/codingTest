package future.January;

import java.util.*;

public class ex2 {

    static class Result implements Comparable<Result>{
        int abs;
        String name;

        Result(int abs, String name) {
            this.abs = abs;
            this.name = name;
        }

        @Override
        public int compareTo(Result o) {
            return this.abs - o.abs;
        }
    }

    static class Node1 implements Comparable<Node1>{
        String name;
        int x;
        int y;

        Node1(String name, int x, int y) {
            this.name = name;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node1 o) {
            int temp1 = this.x - o.x;
            if (temp1 == 0) {
                return this.y - o.y;
            }
            return temp1;
        }
    }

    static class Node2 implements Comparable<Node2>{
        String name;
        int x;
        int y;

        Node2(String name, int x, int y) {
            this.name = name;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node2 o) {
            int temp1 = this.y - o.y;
            if (temp1 == 0) {
                return this.x - o.x;
            }
            return temp1;
        }
    }
    static int t1;
    static int t2;
    static int t3;
    static int t4;
    static Node1 resultNode1;
    static Node2 resultNode2;
    static List<Node1> resultNode1List;
    static List<Node2> resultNode2List;
    static Node1 kingNode;
    static String[] arr1;
    static String[] resultArr;
    static List<Node1> node1List = new ArrayList<>();
    static List<Node2> node2List = new ArrayList<>();
    static List<Node1> kingList = new ArrayList<>();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t1 = sc.nextInt();
        arr1 = new String[t1];
        for (int i = 0; i < t1; i++) {
            arr1[i] = sc.next();
        }


        t2 = sc.nextInt();
        int[] tx = new int[t2];
        for (int i = 0; i < t2; i++) {
            tx[i] = sc.nextInt();
        }

        t3 = sc.nextInt();
        int[] ty = new int[t3];
        for (int i = 0; i < t3; i++) {
            ty[i] = sc.nextInt();
        }

        t4 = sc.nextInt();
        resultArr = new String[t4];
        for (int i = 0; i < t4; i++) {
            int x;
            int y;
            resultArr[i] = sc.next();
            for (int j = 0; j < t1; j++) {
                if (arr1[j].equals(resultArr[i])) {
                    x = tx[j];
                    y = ty[j];
                    kingNode = new Node1(resultArr[i], x, y);
                    kingList.add(kingNode);
                }
            }
        }

        for (int i = 0; i < t1; i++) {
            String name = arr1[i];
            int x = tx[i];
            int y = ty[i];
            Node1 node1 = new Node1(name, x,y);
            Node2 node2 = new Node2(name, x,y);

            node1List.add(node1);
            node2List.add(node2);

        }
        Collections.sort(node1List);
        Collections.sort(node2List);


        for (int i = 0; i < t4; i++) {

            resultNode1List = new ArrayList<>();
            resultNode2List = new ArrayList<>();
            List<Result> results = new ArrayList<>();

            Node1 node1 = kingList.get(i);

            boolean check1 = extracted1(node1.name);
            boolean check2 = extracted2(node1.name);

            if (!check1 && !check2) {
                System.out.println("NONE");
            } else {
                if (!check1) {
                    for (int j = 0; j < resultNode2List.size(); j++) {
                        int abs2 = Math.abs(node1.x - resultNode2List.get(j).x) + Math.abs(node1.y - resultNode2List.get(j).y);
                        Result result = new Result(abs2, resultNode2List.get(j).name);
                        results.add(result);
                    }
                    Collections.sort(results);
                    System.out.println(results.get(0).name);
                } else if (!check2) {
                    for (int j = 0; j < resultNode1List.size(); j++) {
                        int abs1 = Math.abs(node1.x - resultNode1List.get(j).x) + Math.abs(node1.y - resultNode1List.get(j).y);
                        Result result = new Result(abs1, resultNode1List.get(j).name);
                        results.add(result);
                    }
                    Collections.sort(results);
                    System.out.println(results.get(0).name);
                } else {
                    for (int j = 0; j < resultNode2List.size(); j++) {
                        int abs2 = Math.abs(node1.x - resultNode2List.get(j).x) + Math.abs(node1.y - resultNode2List.get(j).y);
                        Result result = new Result(abs2, resultNode2List.get(j).name);
                        results.add(result);
                    }
                    for (int j = 0; j < resultNode1List.size(); j++) {
                        int abs1 = Math.abs(node1.x - resultNode1List.get(j).x) + Math.abs(node1.y - resultNode1List.get(j).y);
                        Result result = new Result(abs1, resultNode1List.get(j).name);
                        results.add(result);
                    }
                    Collections.sort(results);

                    System.out.println(results.get(0).name);
                }
            }
        }
    }

    private static boolean extracted1(String answerName) {
        boolean check = false;

        for (int j = 0; j < t1; j++) {
            if (answerName.equals(node1List.get(j).name)) {
                for (int k = 0; k < t1; k++) {
                    if (j == k) {
                        continue;
                    }
                    if (node1List.get(j).x == node1List.get(k).x) {
                        resultNode1 = new Node1(node1List.get(k).name, node1List.get(k).x, node1List.get(k).y);
                        resultNode1List.add(resultNode1);
                        check = true;
                    } else if (check) {
                        return check;
                    }
                }
            }
        }

        return check;
    }

    private static boolean extracted2(String answerName) {
        boolean check = false;

        for (int j = 0; j < t1; j++) {
            if (answerName.equals(node2List.get(j).name)) {
                for (int k = 0; k < t1; k++) {
                    if (j == k) {
                        continue;
                    }
                    if (node2List.get(j).y == node2List.get(k).y) {
                        resultNode2 = new Node2(node2List.get(k).name, node2List.get(k).x, node2List.get(k).y);
                        resultNode2List.add(resultNode2);
                        check = true;
                    } else if (check) {
                        return check;
                    }
                }
            }
        }

        return check;
    }
}

/*
3
fastcity
bigbanana
xyz
3
23
23
23
3
1
10
20
3
fastcity
bigbanana
xyz
*/

/*
3
london
warsaw
hackerland
3
1
10
20
3
1
10
10
3
london
warsaw
hackerland
*/

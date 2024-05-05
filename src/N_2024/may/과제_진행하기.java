package N_2024.may;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class 과제_진행하기 {
    public static void main(String[] args) {
        String[][] plans = {{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}};
        List<String> result = solution(plans);
        for (String s : result) {
            System.out.println(s);
        }
    }

    public static List<String> solution(String[][] plans) {
        List<String> answer = new LinkedList<>();

        Arrays.sort(plans, Comparator.comparing(plan -> plan[1]));
        Stack<Node> temp = new Stack<>();


        for (int i = 0; i < plans.length; i++) {
            if (i == plans.length - 1) {
                answer.add(plans[i][0]);
                break;
            }

            String time = plans[i][1];
            String[] parts = time.split(":");
            int hour = Integer.parseInt(parts[0]);
            int minute = Integer.parseInt(parts[1]);
            int total = hour * 60 + minute;

            String nextTime = plans[i+1][1];
            String[] nextParts = nextTime.split(":");
            int nextHour = Integer.parseInt(nextParts[0]);
            int nextMinute = Integer.parseInt(nextParts[1]);
            int nextTotal = nextHour * 60 + nextMinute;

            if (total + Integer.parseInt(plans[i][2]) > nextTotal) {
                temp.add(new Node(plans[i][0], total + Integer.parseInt(plans[i][2]) - nextTotal));
            } else {
                answer.add(plans[i][0]);
                total += Integer.parseInt(plans[i][2]);
                nextTotal -= total;
                while (true) {
                    if (temp.isEmpty()) {
                        break;
                    }
                    Node node = temp.pop();
                    if (node.remain > nextTotal) {
                        temp.add(new Node(node.name, node.remain - nextTotal));
                        break;
                    } else if (node.remain == nextTotal) {
                        answer.add(node.name);
                        break;
                    } else {
                        nextTotal -= node.remain;
                        answer.add(node.name);
                    }
                }
            }
        }

        while (!temp.isEmpty()) {
            Node node = temp.pop();
            answer.add(node.name);
        }

        return answer;
    }

    public static class Node {
        String name;
        int remain;

        public Node(String name, int remain) {
            this.name = name;
            this.remain = remain;
        }
    }
}

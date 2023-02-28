import java.util.ArrayList;
class Solution {
    public ArrayList solution(String[] quiz) {
        ArrayList answer = new ArrayList();
        for (String s : quiz) {
            String x = s.substring(0, s.indexOf(" "));
            String op = s.substring(s.indexOf(" ") + 1, s.indexOf(" ") + 2);
            String y = s.substring(s.indexOf(" ") + 3, s.indexOf("=") - 1);
            String re = s.substring(s.indexOf("=") + 2);
            
            if (op.equals("+")) {
                if (Integer.valueOf(x) + Integer.valueOf(y) == Integer.valueOf(re)) {
                    answer.add("O");
                } else {
                    answer.add("X");
                }
            } else {
                if (Integer.valueOf(x) - Integer.valueOf(y) == Integer.valueOf(re)) {
                    answer.add("O");
                } else {
                    answer.add("X");
                }
            }
        }
        return answer;
    }
}
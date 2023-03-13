import java.util.ArrayList;
class Solution {
    public ArrayList solution(String my_str, int n) {
        ArrayList<String> answer = new ArrayList<>();
        int leng = 0;
        while (true) {
            if (leng == my_str.length()) {
                break;
            }
            if (leng + n > my_str.length()) {
                answer.add(my_str.substring(leng, my_str.length()));
                break;
            }
            answer.add(my_str.substring(leng, leng + n));
            leng+=n;
        }
        return answer;
    }
}
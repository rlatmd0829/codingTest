class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while (n >= a) {
            int re = n % a;
            n = n / a;
            answer += n * b;
            n *= b;
            n += re;
        }
        return answer;
    }
}
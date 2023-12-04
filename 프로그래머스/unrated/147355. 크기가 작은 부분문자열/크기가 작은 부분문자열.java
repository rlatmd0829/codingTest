class Solution {
    public int solution(String t, String p) {
        int answer = 0;

        char[] c = t.toCharArray();
        char[] n = new char[p.length()];

        for (int i = 0; i <= c.length - p.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                n[j] = c[j+i];
            }
            String str = String.valueOf(n);

            Long Ip = Long.parseLong(p);
            Long Is = Long.parseLong(str);
            if (Ip >= Is) {
                answer++;
            }

        }
        return answer;
    }
}
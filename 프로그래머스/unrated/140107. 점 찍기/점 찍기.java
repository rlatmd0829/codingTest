class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        for(int i = 0; i <= d; i += k) // x좌표를 k씩 증가시키면서 계산
        {
            long dd = (long) d * d;
            long ii = (long) i * i;
            int top = (int) Math.sqrt(dd - ii); // 원점과 점 사이의 거리가 d 이하인 경우에 대해 y의 상한선 계산
            answer += (top / k) + 1; // y축 방향으로 k씩 이동하는 경우에 대한 점의 개수 계산
        }
        return answer;
    }
}
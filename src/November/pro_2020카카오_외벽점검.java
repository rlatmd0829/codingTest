package November;

public class pro_2020카카오_외벽점검 {
    public int n, min;
    public int[] weak, dist;
    public int[][] rotateWeak;
    public boolean[] visit;

    public static void main(String[] args) {
        int n = 12;
        int[] weak = {1,5,6,10};
        int[] dist = {1,2,3,4};
        pro_2020카카오_외벽점검 pro = new pro_2020카카오_외벽점검();
        pro.solution(n, weak, dist);
    }

    public int solution(int n, int[] weak, int[] dist) {
        int answer = 0;

        this.n = n;
        this.weak = weak;
        this.dist = dist;
        rotateWeak = new int[weak.length][weak.length];
        visit = new boolean[dist.length];
        min = Integer.MAX_VALUE;
        rotate();

        for (int i = 0; i < dist.length; i++) {
//            per(0, i, "");
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public void rotate() {
        for (int j = 0; j < weak.length; j++) {
            int ro[] = new int[weak.length];
            int index = j;

            for (int i = 0; i < weak.length; i++) {
                ro[i] = weak[index % weak.length];

                if (index >= weak.length)
                    ro[i] += n;
                index++;
            }
            rotateWeak[j] = ro;
        }
    }
}

package N_2022.March;

public class pro_L2_joystick {

    public static void main(String[] args) {
        solution("JAN");
    }

    // 실패코드
    // for문으로 i를 왼쪽에서 오른쪽 방향으로 정하고 시작하면 안된다.
    // 시작점 0에서 오른쪽으로 갈수도 있고 왼쪽으로 갈수도있다.
    // 코드 다시 짜보기
    private static void solution(String name) {
        int count = 0;
        int cur = 0;
        char[] c = name.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if ((i != 0) && (c[i] != 'A')) {

                if (Math.abs('A' - c[i]) > Math.abs('Z' - c[i]) + 1) {
                    count += Math.abs('Z' - c[i]) + 1;
                } else {
                    count += Math.abs('A' - c[i]);
                }

                if (Math.abs(i - cur) > c.length - i) {
                    count += c.length - i;
                } else {
                    count += Math.abs(i - cur);
                }
                cur = i;
            } else if (c[i] == 'A') {
            }
            else {
                if (Math.abs('A' - c[i]) > Math.abs('Z' - c[i]) + 1) {
                    count += Math.abs('Z' - c[i]) + 1;
                } else {
                    count += Math.abs('A' - c[i]);
                }
            }


        }
        System.out.println(count);
    }
}

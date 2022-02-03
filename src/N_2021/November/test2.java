package N_2021.November;

public class test2 {


    public static void main(String[] args) {
        // 홀 오른쪽
        // 짝 아래
        int[][] arr1 = new int[3][4];
        int[][] arr2 = new int[3][3];

        int[][] ARR_1 = extracted(arr1, 0, 0, 1);
        int[][] ARR_2 = extracted(arr2, 0, 0, 1);

        for (int i = 0; i < ARR_1.length; i++) {
            for (int j = 0; j < ARR_1[0].length; j++) {
                System.out.print(ARR_1[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        for (int i = 0; i < ARR_2.length; i++) {
            for (int j = 0; j < ARR_2[0].length; j++) {
                System.out.print(ARR_2[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] extracted(int[][] ARR, int x, int y, int COUNT) {

        while (true){
            boolean check = false;
            Loop1:
            for (int i = 0; i < ARR.length; i++) {
                for (int j = 0; j < ARR[0].length; j++) {
                    if (ARR[i][j] == 0){
                        check = true;
                        break Loop1;
                    }
                }
            }
            if (!check){
                return ARR;
            }

            ARR[x][y] = COUNT;

            if (COUNT % 2 == 0){
                x++;
                if (x == ARR.length){
                    x = 0;
                }
            } else {
                y++;
                if (y == ARR[0].length){
                    y = 0;
                }
            }

            COUNT++;

            if (ARR[x][y] % 2 != 0 && COUNT % 2 != 0) {
                return ARR;
            }
        }
    }
}

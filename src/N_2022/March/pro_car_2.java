package N_2022.March;

import java.util.ArrayList;
import java.util.Arrays;

public class pro_car_2 {
    public static void main(String[] args) {
        solution(new int[]{3,7,2,8,6,4,5,1}, 3);
    }

    private static void solution(int[] numbers, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length-1; i++) {
            if (Math.abs(numbers[i] - numbers[i+1]) > k) {
                list.add(numbers[i]);
                int cnt = check(numbers, k);
            }
        }
        System.out.println(Arrays.toString(list.toArray()));
    }

    private static int check(int[] numbers, int k) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (Math.abs(numbers[i] - numbers[i+1]) > k) {
                return -1;
            }
        }
        return 1;
    }

    private static void swap(int[] numbers, int a1, int a2) {
        int temp = numbers[a1];
        numbers[a1] = numbers[a2];
        numbers[a2] = temp;
    }
}

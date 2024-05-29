

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] burgers = new int[3];
        int[] beverages = new int[2];
        int minBuger = Integer.MAX_VALUE;
        int minBeverage = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            burgers[i] = sc.nextInt();
            if (minBuger > burgers[i]) {
                minBuger = burgers[i];
            }
        }

        for (int i = 0; i < 2; i++) {
            beverages[i] = sc.nextInt();
            if (minBeverage > beverages[i])
                minBeverage = beverages[i];
        }

        System.out.println(minBeverage + minBuger - 50);

        
        

        
    }
}

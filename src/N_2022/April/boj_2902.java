package N_2022.April;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class boj_2902 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Character> list = new ArrayList();
        String s = sc.next();
        String[] arr = s.split("-");

        for (String s1 : arr) {
            list.add(s1.charAt(0));
        }

        for (Character character : list) {
            System.out.print(character);
        }
    }
}

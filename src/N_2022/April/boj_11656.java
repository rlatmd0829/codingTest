package N_2022.April;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class boj_11656 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            StringBuilder temp = new StringBuilder();
            for (int j = i; j < c.length; j++) {
                temp.append(c[j]);
            }
            list.add(temp.toString());

        }
        Collections.sort(list);
        for (String s1 : list) {
            System.out.println(s1);
        }
    }
}

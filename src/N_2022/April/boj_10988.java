package N_2022.April;

import java.util.*;

public class boj_10988 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        String[] ss = s.split("");

        String a = String.join("", ss);

        List<String> list = Arrays.asList(ss);

        Collections.reverse(list);

        String b = String.join("", list);

        if (a.equals(b)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }


    }
}

package N_2022.April;

import java.util.*;

public class boj_1764 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = 0;
        List<String> list = new ArrayList<>();
        int N = sc.nextInt();
        int M = sc.nextInt();

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String str = sc.next();
            if (map.containsKey(str)) {
                map.put(str, 1);
            } else {
                map.put(str, 0);
            }
        }

        for (int i = 0; i < M; i++) {
            String str = sc.next();
            if (map.containsKey(str)) {
                map.put(str, 1);
            } else {
                map.put(str, 0);
            }
        }

        for (String s : map.keySet()) {
            if (map.get(s) == 1) {
                list.add(s);
                count++;
            }
        }

        System.out.println(count);
        Collections.sort(list);
        for (String s : list) {
            System.out.println(s);
        }
    }
}

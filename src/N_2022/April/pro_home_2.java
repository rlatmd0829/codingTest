package N_2022.April;

import java.util.*;

public class pro_home_2 {
    static Map<String, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        solution("abxdeydeabz");
    }

    private static void solution(String call) {
        String lowerCase = call.toLowerCase();
        char[] arr = lowerCase.toCharArray();
        boolean[] visited = new boolean[arr.length];

        for (int i = 1; i < arr.length/2; i++) {
            for (int j = 0; j < arr.length; j+=i) {
                String s = "";
                if (arr.length - j >= i) {
                    for (int k = j; k < j+i; k++) {
                        s += arr[k];
                    }
                    if (map.containsKey(s)) {
                        map.put(s, map.get(s) + 1);
                    } else {
                        map.put(s, 1);
                    }
                }
            }
        }

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        int temp = entryList.get(0).getValue();
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> stringIntegerEntry : entryList) {
            if (temp != stringIntegerEntry.getValue()) {
                break;
            } else {
                list.add(stringIntegerEntry.getKey());
            }
        }

        for (int i = 0; i < list.size(); i++) {
            call = lowerCase.replace(list.get(i), "");

        }

        System.out.println(call);
    }
}

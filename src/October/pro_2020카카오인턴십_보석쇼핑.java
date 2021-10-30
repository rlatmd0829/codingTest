package October;

import java.util.*;

public class pro_2020카카오인턴십_보석쇼핑 {

    Set<String> set = new HashSet<>(); // 보석의 종류를 기록
    Map<String, Integer> map = new HashMap<>(); // 보석의 종류별 개수를 기록

    public int[] solution(String[] gems) {
        for (int i = 0; i < gems.length; i++) {
            set.add(gems[i]);
        }
        int start = 0;
        int tempStart = 0;
        int len = gems.length;
        Queue<String> q = new LinkedList<>();
        for (int i = 0; i < gems.length; i++) {
            map.put(gems[i], map.getOrDefault(gems[i], 0) + 1);

            q.add(gems[i]);
            while(true){
                String gem = q.peek();
                if (map.get(gem) > 1){
                    map.put(gem, map.get(gem) - 1);
                    q.poll();
                    tempStart++;
                } else break;
            }

            if(map.size() == set.size()){
                if(len > q.size()){ // 가장 작은 구간을 찾기 위해서, 같은경우도 안된다.
                    len = q.size();
                    start = tempStart;
                }
            }
        }
        return new int[] {start+1, start + len};
    }

}

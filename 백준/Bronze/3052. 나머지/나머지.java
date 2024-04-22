import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){ // 3052 나머지문제
                                            // 이문제는 나머지 값에서 서로다른 개수를 세면 되는것이기 때문에 hashSet을 사용하면된다.
        Scanner sc = new Scanner(System.in);
        HashSet<Integer> h = new HashSet<Integer>();

        for(int i=0; i<10; i++){
            h.add(sc.nextInt()%42);
            // 입력받은 값의 나머지 값을 add메소드를 통해 HashSet에 저장
        }

        System.out.println(h.size());
    }

    // HashSet은 자바 Collection중 Set의 파생클래스 이다.
    // set을 집합이라고 생각하면 되는데, HashSet의 경우 몇 가지 특징이 있다.
    // 1. 중복되는 원소를 넣을 경우 하나만 저장한다.
    // 2. HashSet은 순서 개념이 없다. 따라서 Collections.sort() 메소드를 사용할 수 없다.
    // 만약 정렬을 하고 싶다면 리스트로 변환 후 정렬해야한다.
}

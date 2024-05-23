import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static public void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        String str[][] = new String[N][2];

        for(int i=0; i<N; i++){
            str[i][0] = sc.next();
            str[i][1] = sc.next();
        }

        Arrays.sort(str, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
            }
        });

        for(int i=0; i<N; i++){
            System.out.println(str[i][0] + " " + str[i][1]);
        }
    }
}


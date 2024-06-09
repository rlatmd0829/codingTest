import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        Deque<Integer> de = new LinkedList();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<T; i++){
            String s = sc.next();
            switch (s){
                case "push_back":
                    int a = sc.nextInt();
                    de.addLast(a);
                    break;
                case "push_front":
                    int b= sc.nextInt();
                    de.addFirst(b);
                    break;
                case "pop_front":
                    sb.append(de.isEmpty()?-1:de.removeFirst()).append("\n");
                    break;
                case "pop_back":
                    sb.append(de.isEmpty()?-1:de.removeLast()).append("\n");
                    break;
                case "size":
                    sb.append(de.size()).append("\n");
                    break;
                case "empty":
                    sb.append(de.isEmpty()?1:0).append("\n");
                    break;
                case "front":
                    sb.append(de.isEmpty()?-1:de.peekFirst()).append("\n");
                    break;
                case "back":
                    sb.append(de.isEmpty()?-1:de.peekLast()).append("\n");
                    break;
            }
            
        }
        System.out.println(sb);



    }
}
import java.io.*;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main { // 시간초과 ;; 1406 에디터 문제, StringTokenizer 공부하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> s = new Stack<>();
        Stack<Character> k = new Stack<>();


        String str = br.readLine();
        char arr[] = str.toCharArray();
        for(int i=0; i<arr.length; i++){
            s.push(arr[i]);
        }
        String cnt = br.readLine();
        int count = Integer.parseInt(cnt);
        while (count-- >0){
            String main = br.readLine();
            StringTokenizer st = new StringTokenizer(main); // string을 token 단위로 끊어준다. 디폴트방식이고 공백문자로 나눠준다. split 처럼 지정해줄수 있는데 한문자만로만 나누기가 가능하다.
            String c = st.nextToken();                      // nextToken을 해줘야 처음값이 c에 입력된다.
                if (c.equals("L")) {
                    if(!s.empty()) {
                        char good = s.pop();
                        k.push(good);
                    }
                }else if(c.equals("D")){
                    if(!k.empty()) {
                        char goods = k.pop();
                        s.push(goods);
                    }
                }else if(c.equals("B")){
                    if(!s.empty()){
                        s.pop();
                    }
                }else if(c.equals("P")){

                    s.push(st.nextToken().charAt(0)); // nextToken() 다음 토큰을 리턴한다. 이전토큰은 제거
                }
        }
        while (!s.empty()){
            k.push(s.peek());
            s.pop();
        }
        while (!k.empty()){
            bw.write(k.peek());
            k.pop();
        }
        br.close();
        bw.flush();
        bw.close();
    }
}

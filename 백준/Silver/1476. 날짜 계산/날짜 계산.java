import java.util.Scanner;

public class Main{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int E = sc.nextInt();
        int S = sc.nextInt();
        int M = sc.nextInt();
        int e=1,s=1,m=1,cnt=0;

        while(true){
            cnt++;
            if(E==e && S==s && M==m) {
                System.out.println(cnt);
                break;
            }
            e++;
            s++;
            m++;
            if(e==16){
                e=1;
            }
            if(s==29){
                s=1;
            }
            if(m==20){
                m=1;
            }
        }


    }


}
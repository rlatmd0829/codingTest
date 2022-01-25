package past.November;

import java.util.Objects;

class StringEx {
    String u;
    String v;

    StringEx() {
    }

    StringEx(String u, String v) {
        this.u = u;
        this.v = v;
    }
}

public class pro_2020카카오_괄호변환 {

    public static void main(String[] args) {
        String p = "()))((()";
        System.out.println(solution(p));
    }

    public static String solution(String p) {
        String answer = "";
        if (Objects.equals(p, "")) {
            return "";
        }
        StringEx stringEx = balance(p);
        String u = stringEx.u;
        String v = stringEx.v;
        if (answerString(u)) {
            return u + solution(v);
        } else {
            String demo = "(";
            demo += solution(v) + ")";
            u = u.substring(1,u.length()-1);
            return demo + reverse(u);
        }
    }

    private static StringEx balance(String p) {
        int pStart = 0;
        int pEnd = 0;
        int length = p.length();
        for (int i = 0; i < length; i++) {
            if (p.charAt(i) == '(') {
                pStart++;
            }else 
                pEnd++;
            if (pStart == pEnd)
                return new StringEx(p.substring(0, i+1), p.substring(i+1, length));
        }
        return new StringEx();
    }

    private static boolean answerString(String u) {
        int uStart = 0;
        int uEnd = 0;
        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) == '(') {
                uStart++;
            }else
                uEnd++;
            if (uEnd > uStart) {
                return false;
            }
        }
        return true;
    }

    private static String reverse(String u) {
        String reverseString = "";
        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) == '(') {
                reverseString += ')';
            } else {
                reverseString += '(';
            }
        }
        return reverseString;
    }
}

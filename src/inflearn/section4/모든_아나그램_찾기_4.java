package inflearn.section4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 모든_아나그램_찾기_4 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		String S = in.nextLine();
		String T = in.nextLine();
		int answer = 0;

		int tLength = T.length();

		Map<Character, Integer> mapS = new HashMap<>();
		Map<Character, Integer> mapT = new HashMap<>();

		char[] charsS = S.toCharArray();
		char[] charsT = T.toCharArray();

		for (int i = 0; i < tLength; i++) {
			mapT.put(charsT[i], mapT.getOrDefault(charsT[i], 0) + 1);
		}

		for (int i = 0; i < tLength-1; i++) {
			mapS.put(charsS[i], mapS.getOrDefault(charsS[i], 0) + 1);
		}

		int lt = 0;
		for (int rt = tLength-1; rt < S.length(); rt++) {
			mapS.put(charsS[rt], mapS.getOrDefault(charsS[rt], 0) + 1);

			if (mapT.equals(mapS)) {
				answer++;
			}

			mapS.put(charsS[lt], mapS.get(charsS[lt]) - 1);
			if (mapS.get(charsS[lt]) == 0) {
				mapS.remove(charsS[lt]);
			}
			lt++;

		}
		System.out.println(answer);
	}
}

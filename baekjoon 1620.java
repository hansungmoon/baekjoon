package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main43 {
	
	static boolean isNumber(String quiz) {
		for(int i = 0;i < quiz.length();i++) {
			if(!Character.isDigit(quiz.charAt(i))) {	//문자열 안에 숫자가 있는지 판별
				return false;		//숫자가 있으면 false 반환
			}
		}
		return true;				//아니면 true 반환
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();	//문자열을 요청할때 사용할 Map
		ArrayList<String> list = new ArrayList<String>();				//숫자를 요청할때 사용할 배열
		
		for(int i = 0;i < N;i++) {
			String s = br.readLine();
			map.put(s, i+1);			// 도감이 1부터 숫자를 세므로 i+1
			list.add(s);
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0;i < M;i++) {
			String quiz = br.readLine();
			if(isNumber(quiz)) {	//quiz가 숫자이면
				// 배열은 0 부터 시작하고 도감은 1부터 시작하므로 quiz -1 
				sb.append(list.get(Integer.parseInt(quiz) - 1)).append("\n");
			}
			else {		//quiz가 문자이면
				sb.append(map.get(quiz)).append("\n");
			}
		}
		System.out.println(sb);
	}
}

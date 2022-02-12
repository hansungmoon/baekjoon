package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main24 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int buttonList = Integer.parseInt(br.readLine());

		ArrayList<Character> list = new ArrayList<Character>();		//고장난 버튼 배열
		
		if(buttonList != 0) {										//고장난 버튼이 없으면 입력받지 않음
			
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
			for(int i = 0;i < buttonList;i++) {
				list.add(st.nextToken().charAt(0));		//String을 Character으로 변환
			}
		}
		
		int buttonMove = Math.abs(n-100);			//채널 100 에서 부터 '+','-'로만 움직인 값
		
		int min = 9999999;							//채널의 최대값 : 가장 가까운 채널을 찾기위한 값
		int count = 0;
		
		for(int i = 0;i < 1000000;i++) {			//모든 채널 완전탐색
			String s = String.valueOf(i);			//i값을 String으로 전환
			boolean flag = true;					//오작동 버튼을 체크하는 boolean
			
			for(int k = 0;k < s.length();k++) {
				if(list.contains(s.charAt(k))) {	//오작동 버튼숫자가 포함되어있으면 continue
					flag = false;
					break;
				}
			}
			if(flag == false) {	
				continue;
			}
			
			count = Math.abs(i - n) + s.length();
			
			if(count < min) {
				min = count;
			}
		}
		
		if(min < buttonMove) {
			System.out.println(min);
		}
		else {System.out.println(buttonMove);}
		
	}
}

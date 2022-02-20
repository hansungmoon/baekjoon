package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main48 {
	
	static StringBuilder sb = new StringBuilder();
	
	static void result(String p, Deque<Integer> deq) {
		boolean way = true;			// 배열의 뒤집기 판단
		
		for(int i = 0;i < p.length();i++) {
			if(p.charAt(i) == 'R') {		// 함수의 글자가 R이면
				way = !way;					// 배열 뒤집기
			}
											// 글자가 D일때
			else {
				if(deq.isEmpty()) {			// 덱이 비어있으면 error
					sb.append("error\n");
					return;
				}
				if(way) {					// 정방향이면 덱의 첫번째 제거
					deq.removeFirst();
				}
				else {						// 역방향이면 덱의 마지막 제거
					deq.removeLast();
				}
			}
		}
		
		sb.append('[');						// 덱이 비어있을때도 '['가 있어야하므로
		
		if(deq.size() > 0) {
			
			if(way) {						// 정방향일때
				sb.append(deq.pollFirst());	// 첫번째를 덱에서 빼고 출력
				
				while(!deq.isEmpty()) {		// 덱이 빌 때까지
					sb.append(',').append(deq.pollFirst());	// ','를 찍고 첫번째를 덱에서 빼고 출력
				}
				
			}
			else {
				sb.append(deq.pollLast());
				
				while(!deq.isEmpty()) {
					sb.append(',').append(deq.pollLast());
				}
				
			}
			
		}
		sb.append("]\n");		// 덱이 비어있을때도 ']'가 있어야 하므로
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0;i < T;i++) {
			String p = br.readLine();		// 수행할 함수
			int n = Integer.parseInt(br.readLine());		//배열의 수
			StringTokenizer st = new StringTokenizer(br.readLine(),"[],");	//'[]' ','를 기준으로 분리
			
			Deque<Integer> deq = new LinkedList<Integer>();
			for(int j = 0;j < n;j++) {
				deq.add(Integer.parseInt(st.nextToken()));		//덱에 분리한 숫자를 추가
			}
			
			result(p, deq);
		}
		
		System.out.println(sb);
	}
}

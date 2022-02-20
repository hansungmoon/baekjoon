package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main49 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> q = new PriorityQueue<Integer>();	//작은 수를 먼저 내보내는 우선순위 큐(오름차순 정렬)
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0;i < N;i++) {
			int x = Integer.parseInt(br.readLine());
			if(x == 0) {			// 0일떄
				if(q.isEmpty()) {	// 큐가 비어있으면
					sb.append(0).append("\n");	// 0을 출력
				}
				else {
					sb.append(q.poll()).append("\n");	// 비어있지 않으면 가장 작은 값 출력
				}
			}
			else {
				q.add(x);			// 자연수일 때 큐에 추가
			}
		}
		
		System.out.println(sb);
	}
}

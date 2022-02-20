package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main46 {
	static boolean[] visited = new boolean[100001];		// 위치 최대범위
	static int[] x_way = {-1, 1, 2};					// 움직일수 있는 위치
	
	static void bfs(int N, int K) {
		if(N == K) {System.out.println(0); return;}		// 같은 위치에 있으면 0 출력 
		
		Queue<int[]> q = new LinkedList<int[]>();		
		visited[N] = true;								// 현재위치 방문
		q.add(new int[] {N,0});							// 큐에 현재 위치와 시간 추가
		
		while(!q.isEmpty()) {							// 큐가 빌 때 까지 반복
			int arrX[] = q.poll();						
			int x = arrX[0];							// 변수에 현재 위치 저장
			int x_next;									
			
			for(int i = 0;i < 3;i++) {
				if(i == 2) {							// i == 2면 순간이동을 하는경우
					x_next = x * x_way[i];
				}
				else{
					x_next = x + x_way[i];
				}
				
				// 범위안에 다음 위치가 포함되고 방문한적이 없으면 
				if(x_next >= 0 && x_next <= 100000 && visited[x_next] == false) {
					if(x_next == K) {			// 동생의 위치에 도달하면
						System.out.println(arrX[1]+1);
						return;
					}
					q.add(new int[] {x_next,arrX[1]+1});	// 큐에 다음위치, 시간 + 1 을 해서 추가
					visited[x_next] = true;					// 방문 ture
				}
				
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		bfs(N, K);
	}
}

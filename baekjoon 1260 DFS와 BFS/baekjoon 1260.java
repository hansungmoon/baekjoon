package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main26 {
	static int arr[][];					// 인접행렬 배열
	static boolean visit[];				// 방문 여부 확인을 위한 boolean배열
	
	// 재귀함수를 이용한 dfs
	static void dfs(int V) {
		visit[V] = true;				// 정점 방문 true
		System.out.print(V + " ");		
		
		for(int i = 1;i < arr.length;i++) {
			if(arr[V][i] == 1 && visit[i] == false) {	// 정점 V의 간선이 있고 방문한적이 없으면 
				dfs(i);									// 재귀
			}
		}
	}
	
	// bfs Queue를 사용
	static void bfs(int V) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(V);
		
		visit[V] = true;				// 정점 방문 true
		System.out.print(V + " ");
		
		while(!queue.isEmpty()) {		// Queue가 다 비워질때 까지 반복
			
			int qNum = queue.peek();	
			queue.poll();				// 간선 탐색후  Queue에서 비움
			
			for(int i = 1;i < arr.length;i++) {
				if(arr[qNum][i] == 1 && visit[i] == false) {	// 정점 V의 간선이 있고 방문한적이 없으면 
					queue.add(i);								// 방문한 정점 Queue에 추가
					visit[i] = true;
					System.out.print(i + " ");
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1][N+1];				// 배열 0 번은 사용 안하기 때문에 정점 개수 +1
		
		for(int i = 0;i < M;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			arr[n1][n2] = 1;					// 인접행렬 입력
			arr[n2][n1] = 1;
		}
		
		visit = new boolean[N+1];				// 방문여부 배열 선언 배열 0번은 마찬가지로 사용 안함
		dfs(V);
		
		System.out.println();
		visit = new boolean[N+1];
		bfs(V);
		
	}
	
}

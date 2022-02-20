package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main28 {
	static int[][] arr;
	static int N;
	static int M;
	static boolean visited[][];
	static int[] wayX = {-1, 1, 0, 0};				//상, 하 방향 탐색을 위한 배열
	static int[] wayY = {0, 0, -1, 1};				//좌, 우 방향 탐색을 위한 배열
	
	static void bfs(int x, int y) {
		Queue<int[]> que = new LinkedList<int[]>();
		que.add(new int[] {x,y});					//시작점을 queue에 넣는다
		
		while(!que.isEmpty()) {						//queue가 다 비워질 때 까지 반복
			int[] now = que.poll();					//queue에 첫번째를 비우고 now배열에 넣는다

			x = now[0];								//현 위치 좌표 x, y
			y = now[1];
			
			for(int i = 0;i < 4;i++) {				// 좌,우,상,하 방향 확인하는 반복
				int nextX = x + wayX[i];
				int nextY = y + wayY[i];
				
				if(nextX < 0 || nextY < 0 || nextX >=N || nextY >= M) {		//좌표값이 음수이거나 도착좌표보다 크면
					continue;												
				}
				if(arr[nextX][nextY] == 0 || visited[nextX][nextY] == true) {	//다음 방향 좌표가 0이거나 방문한 곳이면
					continue;
				}
				
				que.add(new int[] {nextX, nextY});						//queue에 다음 좌표값을 넣는다
				visited[nextX][nextY] = true;							//다음 좌표값 방문 처리
				arr[nextX][nextY] = arr[x][y] + 1;						//다음 좌표값을 전 좌표값 +1
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];						//인접 행렬 방식으로 2차원 배열
		
		for(int i = 0;i < N;i++) {
			String s = br.readLine();			
			
			for(int j = 0;j < M;j++) {
				arr[i][j] = s.charAt(j) - '0';		//char을 int로 변환해서 배열에 넣는다
			}
		}
		
		visited = new boolean[N][M];				//방문여부 확인을 위함 2차원 boolean배열 
		visited[0][0] = true;
		
		bfs(0,0);
		
		System.out.println(arr[N-1][M-1]);			//도착지점 출력
		
	}
}

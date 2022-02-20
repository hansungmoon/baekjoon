package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main34 {
	static int[][] arr;						// 배추의 위치를 받을 배열
	static boolean[][] visited;				// 방문 유무를 받을 배열
	static int N, M;
	static int[] wayX = {-1,1,0,0};			// 상,하 방향 탐색
	static int[] wayY = {0,0,-1,1};			// 좌,우 방향 탐색
	
	//재귀를 이용한 dfs 알고리즘
	static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for(int i = 0;i < 4;i++) {
			int nextX = x + wayX[i];		//상,하 좌표 값
			int nextY = y + wayY[i];		//좌,우 좌표 값
			
			if(nextX < 0 || nextY < 0 || nextX >= M || nextY >= N) { //좌표 범위를 벗어나면 continue
				continue;
			}
			if(visited[nextX][nextY] == true || arr[nextX][nextY] == 0) {	//방문한적이 있거나 배추가 없으면 continue
				continue;
			}
			dfs(nextX,nextY);			
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0;i < n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			arr = new int[M][N];
			visited = new boolean[M][N];
			
			for(int j = 0;j < K;j++) {		// 배열에 배추 위치 값 넣기
				st = new StringTokenizer(br.readLine(), " ");
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				arr[X][Y] = 1;
			}
			
			int count = 0;					// 지렁이 갯수 Count
			
			for(int j = 0;j < M;j++) {
				for(int k = 0;k < N;k++) {
					if(arr[j][k] == 1 && visited[j][k] == false) {	//배추가 심어져 있고 방문한 적이 없으면 
						dfs(j,k);
						count++;			// dfs재귀 메서드를 호출 할 때 마다 지렁이 갯수 +
					}
				}
			}
			System.out.println(count);
		}
	}
}
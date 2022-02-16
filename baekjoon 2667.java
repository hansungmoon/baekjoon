package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main37 {
	static int[][] arr; // 단지의 위치를 받을 배열
	static boolean[][] visited; // 방문 유무를 받을 배열
	static int N;
	static int[] wayX = { -1, 1, 0, 0 }; // 상,하 방향 탐색
	static int[] wayY = { 0, 0, -1, 1 }; // 좌,우 방향 탐색
	static int countH = 1;				// 단지에 속하는 집의 수 

	// 재귀를 이용한 dfs 알고리즘
	static void dfs(int x, int y) {
		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nextX = x + wayX[i]; // 상,하 좌표 값
			int nextY = y + wayY[i]; // 좌,우 좌표 값

			if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) { // 좌표 범위를 벗어나면 continue
				continue;
			}
			if (visited[nextX][nextY] == true || arr[nextX][nextY] == 0) { // 방문한적이 있거나 배추가 없으면 continue
				continue;
			}
			countH++;
			dfs(nextX, nextY);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());

		arr = new int[N][N];			// 가로 세로의 크기는 같다
		visited = new boolean[N][N];
		
		for(int i = 0;i < N;i++) {
			String s = br.readLine();
			for(int j = 0;j < N;j++) {
				arr[i][j] = s.charAt(j) - '0';	//char를 int로 변환하여 넣음
			}
		}

		int count = 0; // 단지수 Count
		
		ArrayList<Integer> list = new ArrayList<Integer>();	// 단지의 집수를 정렬할 배열

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 1 && visited[i][j] == false) { // 집이 있고 방문한적이 없으면
					dfs(i, j);				
					count++;				// dfs가 실행될 때 마다 +
					list.add(countH);		// 카운트한 집수를 list에 추가
					countH = 1;				// 집수 초기화
				}
			}
		}
		sb.append(count).append("\n");
		list.sort(null);					// 오름차순 정렬
		
		for(int i = 0;i < list.size();i++) {
			sb.append(list.get(i)).append("\n");
		}
		System.out.println(sb);
	}
}

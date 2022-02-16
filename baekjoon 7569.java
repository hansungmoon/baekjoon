package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main38 {
	static int M,N,H;
	static int[][][] arr;
	static int[] wayX;
	static int[] wayY;
	static int[] wayH;
	static Queue<int[]> q = new LinkedList<int[]>();
	
	static int bfs() {
		while(!q.isEmpty()) {				//큐가 비워질 때 까지 반복
			int[] now = q.poll();			
			
			int h = now[0];					
			int x = now[1];					
			int y = now[2];					
			
			for(int i = 0;i < 6;i++) {		//윗층,아래층,상,하,좌,우 확인
				int nextH = h + wayH[i];
				int nextX = x + wayX[i];
				int nextY = y + wayY[i];
				
				//범위 안에 들어오면
				if(nextH >= 0 && nextX >= 0 && nextY >= 0 && nextH < H && nextX < N && nextY < M) {
					if(arr[nextH][nextX][nextY] == 0) {		//안익은 토마토 이면
						q.add(new int[] {nextH, nextX, nextY});	//큐에 추가
						arr[nextH][nextX][nextY] = arr[h][x][y] +1;	//다음 토마토 = 현재 토마토 +1
					}											//토마토가 며칠만에 익는지 구하기 위해서
				}
			}
		}
		
		int result = Integer.MIN_VALUE;			//int의 최솟값
				
		for(int i = 0;i < H;i++) {
			for(int j = 0;j < N;j++) {
				for(int k = 0;k < M;k++) {
					if(arr[i][j][k] == 0) {		//안익은 토마토가 있으면
						return -1;
					}
					result = Math.max(result, arr[i][j][k]);	//최대 일수를 계속 비교하여 저장
				}
			}
		}
		
		if(result == 1) {			//처음부터 모든 토마토가 다 익어있으면
			return 0;
		}
		else {
			return result -1;		//최대 일수는 1부터 올라갔기에 -1
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		arr = new int[H][N][M];					//토마토의 상태를 받을 3차원 배열
		
		wayX = new int[] {-1, 1, 0, 0, 0, 0};	//상,하 방향 확인
		wayY = new int[] {0, 0, -1, 1, 0, 0};	//좌,우 방향 확인
		wayH = new int[] {0, 0, 0, 0, -1, 1};	//윗층 아랫층 확인
		
		
		for(int i = 0;i < H;i++) {
			for(int j = 0;j < N;j++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int k = 0;k < M;k++) {
					int num = Integer.parseInt(st.nextToken());		//토마토 상태를 배열에 입력
					arr[i][j][k] = num;
					
					if(arr[i][j][k] == 1) {					//토마토가 익었으면 
						q.add(new int[] {i,j,k});			//큐에 추가
					}
				}
			}
		}
		
		System.out.println(bfs());
		
	}
}

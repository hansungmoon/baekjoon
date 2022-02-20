package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main34 {
	static int[][] arr;						// ������ ��ġ�� ���� �迭
	static boolean[][] visited;				// �湮 ������ ���� �迭
	static int N, M;
	static int[] wayX = {-1,1,0,0};			// ��,�� ���� Ž��
	static int[] wayY = {0,0,-1,1};			// ��,�� ���� Ž��
	
	//��͸� �̿��� dfs �˰���
	static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for(int i = 0;i < 4;i++) {
			int nextX = x + wayX[i];		//��,�� ��ǥ ��
			int nextY = y + wayY[i];		//��,�� ��ǥ ��
			
			if(nextX < 0 || nextY < 0 || nextX >= M || nextY >= N) { //��ǥ ������ ����� continue
				continue;
			}
			if(visited[nextX][nextY] == true || arr[nextX][nextY] == 0) {	//�湮������ �ְų� ���߰� ������ continue
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
			
			for(int j = 0;j < K;j++) {		// �迭�� ���� ��ġ �� �ֱ�
				st = new StringTokenizer(br.readLine(), " ");
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				arr[X][Y] = 1;
			}
			
			int count = 0;					// ������ ���� Count
			
			for(int j = 0;j < M;j++) {
				for(int k = 0;k < N;k++) {
					if(arr[j][k] == 1 && visited[j][k] == false) {	//���߰� �ɾ��� �ְ� �湮�� ���� ������ 
						dfs(j,k);
						count++;			// dfs��� �޼��带 ȣ�� �� �� ���� ������ ���� +
					}
				}
			}
			System.out.println(count);
		}
	}
}
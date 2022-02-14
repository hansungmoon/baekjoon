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
	static int[] wayX = {-1, 1, 0, 0};				//��, �� ���� Ž���� ���� �迭
	static int[] wayY = {0, 0, -1, 1};				//��, �� ���� Ž���� ���� �迭
	
	static void bfs(int x, int y) {
		Queue<int[]> que = new LinkedList<int[]>();
		que.add(new int[] {x,y});					//�������� queue�� �ִ´�
		
		while(!que.isEmpty()) {						//queue�� �� ����� �� ���� �ݺ�
			int[] now = que.poll();					//queue�� ù��°�� ���� now�迭�� �ִ´�

			x = now[0];								//�� ��ġ ��ǥ x, y
			y = now[1];
			
			for(int i = 0;i < 4;i++) {				// ��,��,��,�� ���� Ȯ���ϴ� �ݺ�
				int nextX = x + wayX[i];
				int nextY = y + wayY[i];
				
				if(nextX < 0 || nextY < 0 || nextX >=N || nextY >= M) {		//��ǥ���� �����̰ų� ������ǥ���� ũ��
					continue;												
				}
				if(arr[nextX][nextY] == 0 || visited[nextX][nextY] == true) {	//���� ���� ��ǥ�� 0�̰ų� �湮�� ���̸�
					continue;
				}
				
				que.add(new int[] {nextX, nextY});						//queue�� ���� ��ǥ���� �ִ´�
				visited[nextX][nextY] = true;							//���� ��ǥ�� �湮 ó��
				arr[nextX][nextY] = arr[x][y] + 1;						//���� ��ǥ���� �� ��ǥ�� +1
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];						//���� ��� ������� 2���� �迭
		
		for(int i = 0;i < N;i++) {
			String s = br.readLine();			
			
			for(int j = 0;j < M;j++) {
				arr[i][j] = s.charAt(j) - '0';		//char�� int�� ��ȯ�ؼ� �迭�� �ִ´�
			}
		}
		
		visited = new boolean[N][M];				//�湮���� Ȯ���� ���� 2���� boolean�迭 
		visited[0][0] = true;
		
		bfs(0,0);
		
		System.out.println(arr[N-1][M-1]);			//�������� ���
		
	}
}

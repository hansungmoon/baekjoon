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
		while(!q.isEmpty()) {				//ť�� ����� �� ���� �ݺ�
			int[] now = q.poll();			
			
			int h = now[0];					
			int x = now[1];					
			int y = now[2];					
			
			for(int i = 0;i < 6;i++) {		//����,�Ʒ���,��,��,��,�� Ȯ��
				int nextH = h + wayH[i];
				int nextX = x + wayX[i];
				int nextY = y + wayY[i];
				
				//���� �ȿ� ������
				if(nextH >= 0 && nextX >= 0 && nextY >= 0 && nextH < H && nextX < N && nextY < M) {
					if(arr[nextH][nextX][nextY] == 0) {		//������ �丶�� �̸�
						q.add(new int[] {nextH, nextX, nextY});	//ť�� �߰�
						arr[nextH][nextX][nextY] = arr[h][x][y] +1;	//���� �丶�� = ���� �丶�� +1
					}											//�丶�䰡 ��ĥ���� �ʹ��� ���ϱ� ���ؼ�
				}
			}
		}
		
		int result = Integer.MIN_VALUE;			//int�� �ּڰ�
				
		for(int i = 0;i < H;i++) {
			for(int j = 0;j < N;j++) {
				for(int k = 0;k < M;k++) {
					if(arr[i][j][k] == 0) {		//������ �丶�䰡 ������
						return -1;
					}
					result = Math.max(result, arr[i][j][k]);	//�ִ� �ϼ��� ��� ���Ͽ� ����
				}
			}
		}
		
		if(result == 1) {			//ó������ ��� �丶�䰡 �� �;�������
			return 0;
		}
		else {
			return result -1;		//�ִ� �ϼ��� 1���� �ö󰬱⿡ -1
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		arr = new int[H][N][M];					//�丶���� ���¸� ���� 3���� �迭
		
		wayX = new int[] {-1, 1, 0, 0, 0, 0};	//��,�� ���� Ȯ��
		wayY = new int[] {0, 0, -1, 1, 0, 0};	//��,�� ���� Ȯ��
		wayH = new int[] {0, 0, 0, 0, -1, 1};	//���� �Ʒ��� Ȯ��
		
		
		for(int i = 0;i < H;i++) {
			for(int j = 0;j < N;j++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int k = 0;k < M;k++) {
					int num = Integer.parseInt(st.nextToken());		//�丶�� ���¸� �迭�� �Է�
					arr[i][j][k] = num;
					
					if(arr[i][j][k] == 1) {					//�丶�䰡 �;����� 
						q.add(new int[] {i,j,k});			//ť�� �߰�
					}
				}
			}
		}
		
		System.out.println(bfs());
		
	}
}

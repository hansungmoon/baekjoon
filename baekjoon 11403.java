package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main42 {
	// �÷��̵� �ͼ� �˰����� �̿� (Floyd Warshall)
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][N];	//������ ����ũ�⸸ŭ �迭 �ʱ�ȭ
		
		for(int i = 0;i < N;i++) {	//���� ��� �迭�� ����
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j = 0;j < N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0;i < N;i++) {	//���İ��� ���
			for(int j = 0;j < N;j++) {	//��� ���
				for(int k = 0;k < N;k++) {	//���� ���
					if(arr[j][i] == 1 && arr[i][k] == 1) {	//��� ��� -> ���İ��� ��� == 1,
						arr[j][k] = 1;						//���İ��� ��� -> ���� ��� == 1 �̸� ��ΰ� ����
					}
				}
			}
		}
		
		for(int i = 0;i < N;i++) {		//��� �ݺ���
			for(int j = 0;j < N;j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}

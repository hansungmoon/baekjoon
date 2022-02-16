package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main37 {
	static int[][] arr; // ������ ��ġ�� ���� �迭
	static boolean[][] visited; // �湮 ������ ���� �迭
	static int N;
	static int[] wayX = { -1, 1, 0, 0 }; // ��,�� ���� Ž��
	static int[] wayY = { 0, 0, -1, 1 }; // ��,�� ���� Ž��
	static int countH = 1;				// ������ ���ϴ� ���� �� 

	// ��͸� �̿��� dfs �˰���
	static void dfs(int x, int y) {
		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nextX = x + wayX[i]; // ��,�� ��ǥ ��
			int nextY = y + wayY[i]; // ��,�� ��ǥ ��

			if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) { // ��ǥ ������ ����� continue
				continue;
			}
			if (visited[nextX][nextY] == true || arr[nextX][nextY] == 0) { // �湮������ �ְų� ���߰� ������ continue
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

		arr = new int[N][N];			// ���� ������ ũ��� ����
		visited = new boolean[N][N];
		
		for(int i = 0;i < N;i++) {
			String s = br.readLine();
			for(int j = 0;j < N;j++) {
				arr[i][j] = s.charAt(j) - '0';	//char�� int�� ��ȯ�Ͽ� ����
			}
		}

		int count = 0; // ������ Count
		
		ArrayList<Integer> list = new ArrayList<Integer>();	// ������ ������ ������ �迭

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 1 && visited[i][j] == false) { // ���� �ְ� �湮������ ������
					dfs(i, j);				
					count++;				// dfs�� ����� �� ���� +
					list.add(countH);		// ī��Ʈ�� ������ list�� �߰�
					countH = 1;				// ���� �ʱ�ȭ
				}
			}
		}
		sb.append(count).append("\n");
		list.sort(null);					// �������� ����
		
		for(int i = 0;i < list.size();i++) {
			sb.append(list.get(i)).append("\n");
		}
		System.out.println(sb);
	}
}

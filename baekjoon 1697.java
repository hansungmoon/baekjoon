package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main46 {
	static boolean[] visited = new boolean[100001];		// ��ġ �ִ����
	static int[] x_way = {-1, 1, 2};					// �����ϼ� �ִ� ��ġ
	
	static void bfs(int N, int K) {
		if(N == K) {System.out.println(0); return;}		// ���� ��ġ�� ������ 0 ��� 
		
		Queue<int[]> q = new LinkedList<int[]>();		
		visited[N] = true;								// ������ġ �湮
		q.add(new int[] {N,0});							// ť�� ���� ��ġ�� �ð� �߰�
		
		while(!q.isEmpty()) {							// ť�� �� �� ���� �ݺ�
			int arrX[] = q.poll();						
			int x = arrX[0];							// ������ ���� ��ġ ����
			int x_next;									
			
			for(int i = 0;i < 3;i++) {
				if(i == 2) {							// i == 2�� �����̵��� �ϴ°��
					x_next = x * x_way[i];
				}
				else{
					x_next = x + x_way[i];
				}
				
				// �����ȿ� ���� ��ġ�� ���Եǰ� �湮������ ������ 
				if(x_next >= 0 && x_next <= 100000 && visited[x_next] == false) {
					if(x_next == K) {			// ������ ��ġ�� �����ϸ�
						System.out.println(arrX[1]+1);
						return;
					}
					q.add(new int[] {x_next,arrX[1]+1});	// ť�� ������ġ, �ð� + 1 �� �ؼ� �߰�
					visited[x_next] = true;					// �湮 ture
				}
				
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		bfs(N, K);
	}
}

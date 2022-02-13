package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main26 {
	static int arr[][];					// ������� �迭
	static boolean visit[];				// �湮 ���� Ȯ���� ���� boolean�迭
	
	// ����Լ��� �̿��� dfs
	static void dfs(int V) {
		visit[V] = true;				// ���� �湮 true
		System.out.print(V + " ");		
		
		if(V == arr.length) {			// �迭�� �� Ž���ϸ� return
			return;
		}
		
		for(int i = 1;i < arr.length;i++) {
			if(arr[V][i] == 1 && visit[i] == false) {	// ���� V�� ������ �ְ� �湮������ ������ 
				dfs(i);									// ���
			}
		}
	}
	
	// bfs Queue�� ���
	static void bfs(int V) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(V);
		
		visit[V] = true;				// ���� �湮 true
		System.out.print(V + " ");
		
		while(!queue.isEmpty()) {		// Queue�� �� ������� ���� �ݺ�
			
			int qNum = queue.peek();	
			queue.poll();				// ���� Ž����  Queue���� ���
			
			for(int i = 1;i < arr.length;i++) {
				if(arr[qNum][i] == 1 && visit[i] == false) {	// ���� V�� ������ �ְ� �湮������ ������ 
					queue.add(i);								// �湮�� ���� Queue�� �߰�
					visit[i] = true;
					System.out.print(i + " ");
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1][N+1];				// �迭 0 ���� ��� ���ϱ� ������ ���� ���� +1
		
		for(int i = 0;i < M;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			arr[n1][n2] = 1;					// ������� �Է�
			arr[n2][n1] = 1;
		}
		
		visit = new boolean[N+1];				// �湮���� �迭 ���� �迭 0���� ���������� ��� ����
		dfs(V);
		
		System.out.println();
		visit = new boolean[N+1];
		bfs(V);
		
	}
	
}

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main40 {
	static int[][] arr;
	static boolean[] visited;
	static int count = 0;
	
	static void bfs(int V) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {V,0});			// �������� �ɺ� �������� ���� �ܰ踦 �迭�� ��� ����
		
		visited[V] = true;				// ���� �湮 true
		
		while(!q.isEmpty()) {		// Queue�� �� ������� ���� �ݺ�
			int[] qArr = q.poll();	// Queue���� ���� ���� �� ������ ��´�			
			int qNum = qArr[0];		// �ɺ� �������� �� �ܰ� 
			
			for(int i = 1;i < arr.length;i++) {
				if(arr[qNum][i] == 1 && visited[i] == false) {	// ���� V�� ������ �ְ� �湮������ ������ 
					q.add(new int[] {i,qArr[1]+1});		// �湮�� ����, ���� �ܰ� +1�� Queue�� �߰�
					visited[i] = true;		//�ش� ���� �湮 ó��
					count += qArr[1]+1;		//���� �ܰ� +1�� count�� ���Ѵ�
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1][N+1];
		
		for(int i = 0;i < M;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			arr[n1][n2] = 1;
			arr[n2][n1] = 1;
		}
		
		// �������� key������ �ϰ� �ɺ� �������� ���� value���� ��´�
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		
		for(int i = 1;i <= N;i++) {
			visited = new boolean[N+1];
			bfs(i);
			map.put(i, count);	//key : ������, value : �ɺ� �������� ��
			count = 0;			// 0���� �ʱ�ȭ
		}
		
		int result = Integer.MAX_VALUE;	// int�� max��
		int mapKey = 0;
		
		for(int i = map.size();i > 0;i--) {
			int in = map.get(i);
			if(in <= result) {		//�ּڰ��� �������� ��쿡 ���� ���� �ޱ����� '<='
				result = in;
				mapKey = i;			//�ּڰ��� ���� key��
			}
		}

		System.out.println(mapKey);
	}
}

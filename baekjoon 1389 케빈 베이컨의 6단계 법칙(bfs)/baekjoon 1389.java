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
		q.add(new int[] {V,0});			// 시작점과 케빈 베이컨의 수의 단계를 배열에 담아 저장
		
		visited[V] = true;				// 정점 방문 true
		
		while(!q.isEmpty()) {		// Queue가 다 비워질때 까지 반복
			int[] qArr = q.poll();	// Queue에서 정점 제거 후 변수에 담는다			
			int qNum = qArr[0];		// 케빈 베이컨의 수 단계 
			
			for(int i = 1;i < arr.length;i++) {
				if(arr[qNum][i] == 1 && visited[i] == false) {	// 정점 V의 간선이 있고 방문한적이 없으면 
					q.add(new int[] {i,qArr[1]+1});		// 방문한 정점, 현재 단계 +1을 Queue에 추가
					visited[i] = true;		//해당 정점 방문 처리
					count += qArr[1]+1;		//현재 단계 +1을 count에 더한다
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
		
		// 시작점을 key값으로 하고 케빈 베이컨의 수를 value값에 담는다
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		
		for(int i = 1;i <= N;i++) {
			visited = new boolean[N+1];
			bfs(i);
			map.put(i, count);	//key : 시작점, value : 케빈 베이컨의 수
			count = 0;			// 0으로 초기화
		}
		
		int result = Integer.MAX_VALUE;	// int의 max값
		int mapKey = 0;
		
		for(int i = map.size();i > 0;i--) {
			int in = map.get(i);
			if(in <= result) {		//최솟값이 여러개일 경우에 작은 값을 받기위해 '<='
				result = in;
				mapKey = i;			//최솟값을 가진 key값
			}
		}

		System.out.println(mapKey);
	}
}

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main42 {
	// 플로이드 와샬 알고리즘을 이용 (Floyd Warshall)
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][N];	//정점의 개수크기만큼 배열 초기화
		
		for(int i = 0;i < N;i++) {	//인접 행렬 배열에 저장
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j = 0;j < N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0;i < N;i++) {	//거쳐가는 노드
			for(int j = 0;j < N;j++) {	//출발 노드
				for(int k = 0;k < N;k++) {	//도착 노드
					if(arr[j][i] == 1 && arr[i][k] == 1) {	//출발 노드 -> 거쳐가는 노드 == 1,
						arr[j][k] = 1;						//거쳐가는 노드 -> 도착 노드 == 1 이면 경로가 있음
					}
				}
			}
		}
		
		for(int i = 0;i < N;i++) {		//출력 반복문
			for(int j = 0;j < N;j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}

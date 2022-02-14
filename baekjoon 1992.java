package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main30 {
	static int[][] arr;									//흑,백을 숫자로 받을 배열
	static StringBuilder sb = new StringBuilder();		
	
	static boolean pressureB(int x, int y, int size) {	//사이즈 만큼 같은 숫자로 이루어져 있는지 판별
		int startNum = arr[x][y];
		
		for(int i = x;i < size + x;i++) {
			
			for(int j = y;j < size + y;j++) {
				if(arr[i][j] != startNum) {
					return false;
				}
			}
		}
		return true;
	}
	
	//재귀 함수를 이용한 QuadTree 알고리즘
	static void QuadTree(int x, int y,int size) {
		if(pressureB(x,y,size)) {					//size만큼이 같은 숫자이면 압축
			sb.append(arr[x][y]);
			return;
		}
		
		int halfSize = size / 2;					//size안에 다른 숫자가 포함되어있으면 반으로 줄인다
		
		sb.append('(');								//사이즈가 나누어지므로 '('
		
		QuadTree(x, y, halfSize);							//1. 왼쪽 위 구역
		QuadTree(x, y + halfSize, halfSize);				//2. 오른쪽 위 구역
		QuadTree(x + halfSize, y, halfSize);				//3. 왼쪽 아래 구역
		QuadTree(x + halfSize, y + halfSize, halfSize);		//4. 오른쪽 아래 구역
		
		sb.append(')');
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		
		for(int i = 0;i < N;i++) {						//흑,백을 1,0으로 받아서 배열에 저장
			String st = br.readLine();
			for(int j = 0;j < N;j++) {
				arr[i][j] = st.charAt(j) - '0';
			}
		}
		
		QuadTree(0, 0, N);								//0,0부터 시작
		System.out.println(sb);
		
	}
}

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main9 {
	static boolean[][] arr;
	static int min = 64;
	
	static void result(int x, int y) {
		int XM = x+8;
		int YM = y+8;
		int count = 0;
		
		boolean bo = arr[x][y];
		
		for(int i = x;i < XM;i++) {
			for(int j = y;j < YM;j++) {
				if(arr[i][j] != bo) {
					count++;
				}
				bo = !bo;
			}
			bo = !bo;
		}
		count = Math.min(count, 64-count);
		min = Math.min(min, count);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n1 = Integer.parseInt(st.nextToken());
		int n2 = Integer.parseInt(st.nextToken());
		
		arr = new boolean[n1][n2];
		
		for(int i = 0;i < n1;i++) {
			String ST = br.readLine();
			for(int j = 0;j < n2;j++) {
				if(ST.charAt(j) == 'W') {arr[i][j] = true;}
				else {arr[i][j] = false;}
			}
		}
		
		int NM = n1 - 7;
		int MM = n2 - 7;
		
		for(int i = 0;i < NM;i++) {
			for(int j = 0;j < MM;j++) {
				result(i,j);
			}
		}
		System.out.println(min);
		
	}
}

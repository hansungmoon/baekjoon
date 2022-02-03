package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main5 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0;i < n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			int sum1 = x1 - x2;
			int sum2 = y1 - y2;
			int sum3 = r1 - r2;
			int sum4 = r1 + r2;
			
			if(x1 == x2 && y1 == y2 && r1 == r2) {
				System.out.println(-1);
			}
			else if(Math.pow(sum1,2) + Math.pow(sum2,2) == Math.pow(sum3,2)) {
				System.out.println(1);
			}
			else if(Math.pow(sum1,2) + Math.pow(sum2,2) == Math.pow(sum4,2)) {
				System.out.println(1);
			}
			else if(Math.pow(sum1,2) + Math.pow(sum2,2) < Math.pow(sum3,2)) {
				System.out.println(0);
			}
			else if(Math.pow(sum1,2) + Math.pow(sum2,2) > Math.pow(sum4,2)) {
				System.out.println(0);
			}
			else {System.out.println(2);}
		}
		
		br.close();
		
	
	}
}

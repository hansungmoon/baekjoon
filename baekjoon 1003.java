package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main33 {
	//dp를 이용한 재귀
	static Integer dp[][] = new Integer[41][2];		//dp 2차원 배열 [N의 최대][0출력,1출력]
	
	static Integer[] fibonacci(int N) {
		if(dp[N][0] == null && dp[N][1] == null) {	//아직 저장된 값이 없으면
			dp[N][0] = fibonacci(N-1)[0] + fibonacci(N-2)[0];	//N의 0출력 횟수 
			dp[N][1] = fibonacci(N-1)[1] + fibonacci(N-2)[1];	//N의 1출력 횟수
		}
		
		return dp[N];								//저장된 값이 있으면 N의 0출력 1출력이 담긴 dp[N] return
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		dp[0][0] = 1;	//N = 0 0출력 횟수
		dp[0][1] = 0;	//N = 0 1출력 횟수
		dp[1][0] = 0;	//N = 1 0출력 횟수
		dp[1][1] = 1;	//N = 1 1출력 횟수
		
		for(int i = 0;i < T;i++) {
			int N = Integer.parseInt(br.readLine());
			fibonacci(N);
			sb.append(dp[N][0] + " " + dp[N][1]).append("\n");
		}
		System.out.println(sb);
	}
}

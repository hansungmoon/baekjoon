package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main33 {
	//dp�� �̿��� ���
	static Integer dp[][] = new Integer[41][2];		//dp 2���� �迭 [N�� �ִ�][0���,1���]
	
	static Integer[] fibonacci(int N) {
		if(dp[N][0] == null && dp[N][1] == null) {	//���� ����� ���� ������
			dp[N][0] = fibonacci(N-1)[0] + fibonacci(N-2)[0];	//N�� 0��� Ƚ�� 
			dp[N][1] = fibonacci(N-1)[1] + fibonacci(N-2)[1];	//N�� 1��� Ƚ��
		}
		
		return dp[N];								//����� ���� ������ N�� 0��� 1����� ��� dp[N] return
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		dp[0][0] = 1;	//N = 0 0��� Ƚ��
		dp[0][1] = 0;	//N = 0 1��� Ƚ��
		dp[1][0] = 0;	//N = 1 0��� Ƚ��
		dp[1][1] = 1;	//N = 1 1��� Ƚ��
		
		for(int i = 0;i < T;i++) {
			int N = Integer.parseInt(br.readLine());
			fibonacci(N);
			sb.append(dp[N][0] + " " + dp[N][1]).append("\n");
		}
		System.out.println(sb);
	}
}

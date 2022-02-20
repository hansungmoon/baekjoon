package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main45 {
	static int min = Integer.MAX_VALUE;
	
	static void result(int N, int count) {
		if(N == 1) {
			min = Math.min(min, count);		//N�� 1�̸� ���� Ƚ���� ���� ���� Ƚ���� ���� ������ ����
			return;
		}
		if(count > min) {					//Ƚ���� ����Ƚ������ ������ ����
			return;
		}
		
		if(N % 3 == 0) {
			result(N / 3, count + 1);		// 3���� �������� ����Ƚ�� +1�� �ؼ� ���
		}
		if(N % 2 == 0) {
			result(N / 2, count + 1);		// 2�� �������� ����Ƚ�� +1�� �ؼ� ���
		}
		result(N - 1, count + 1);			// 1�� ������ ����Ƚ�� +1�� �ؼ� ���
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		result(N, 0);
		System.out.println(min);
	}
}

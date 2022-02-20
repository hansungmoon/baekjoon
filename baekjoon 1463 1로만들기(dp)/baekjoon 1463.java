package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main45 {
	static int min = Integer.MAX_VALUE;
	
	static void result(int N, int count) {
		if(N == 1) {
			min = Math.min(min, count);		//N이 1이면 연산 횟수와 현재 최저 횟수를 비교해 작은것 저장
			return;
		}
		if(count > min) {					//횟수가 최저횟수보다 많으면 리턴
			return;
		}
		
		if(N % 3 == 0) {
			result(N / 3, count + 1);		// 3으로 나눈값과 연산횟수 +1을 해서 재귀
		}
		if(N % 2 == 0) {
			result(N / 2, count + 1);		// 2로 나눈값과 연산횟수 +1을 해서 재귀
		}
		result(N - 1, count + 1);			// 1을 뺀값과 연산횟수 +1을 해서 재귀
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		result(N, 0);
		System.out.println(min);
	}
}

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main6 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st1.nextToken());
		int max = Integer.parseInt(st1.nextToken());
		int result = 0;
		int[] arr = new int[n];
		StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
		for(int i = 0;i < n;i++) {
			arr[i] = Integer.parseInt(st2.nextToken());
		}
		for(int i = 0;i < n-2;i++) {
			
			for(int j = i+1;j < n-1;j++) {
				
				for(int k = j+1;k < n;k++) {
					
					int sum = arr[i] + arr[j] + arr[k];
					if(sum > result && sum <= max) {
						result = sum;
					}
					if(result == max) {
						System.out.println(result);
						return;}
				}
			}
		}
		System.out.println(result);
	}
}

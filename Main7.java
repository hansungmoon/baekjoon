package baekjoon;

import java.util.Scanner;

public class Main7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i = 0;i < N;i++) {
			int n = i;
			int result = 0;
		
			while(n != 0) {
				result += n%10;
				n /= 10;
			}
			
			if(result + i == N) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(0);
	}
}

package baekjoon;

import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int V = sc.nextInt();
		int count =0;
		
		count = (V-B) / (A-B);
		
		if((V-B) % (A-B) != 0) {
			count++;
		}
		System.out.println(count);
	}
}

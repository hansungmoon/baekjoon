package baekjoon;

import java.util.Scanner;

public class Main1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 1;
		long range = 0;
		int p = 6;
		while(range+1 < n) {
			range += p;
			p += 6;
			count++;
		}
		System.out.println(count);
	}
}

package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int n3 = sc.nextInt();
		int m = n3 - n2;
		int result;
		if(m <= 0) {System.out.println(-1); return;}
		
		result = n1/m +1;
		System.out.println(result);
	}
}

package baekjoon;

import java.util.Scanner;

public class Main4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double n = sc.nextInt();
		System.out.printf("%.6f\n",Math.pow(n, 2) * Math.PI);
		System.out.printf("%.6f\n",Math.pow(n, 2) * 2);
		sc.close();
	}
}

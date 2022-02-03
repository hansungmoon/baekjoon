package baekjoon;

import java.util.Scanner;


public class Main8 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arrw = new int[n];
		int[] arrh = new int[n];
		
		for(int i = 0;i < n;i++) {
			arrw[i] = sc.nextInt();
			arrh[i] = sc.nextInt();
		}
		for(int i = 0;i < n;i++) {
			int count = 0;
			
			for(int j = 0;j < n;j++) {
				if(i == j) {continue;}
				if(arrw[i] < arrw[j] && arrh[i] < arrh[j]) {
					count++;}
			}
			System.out.print((count + 1) + " ");
		}

	}
}

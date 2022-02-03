package baekjoon;

import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int total = 0;
		int line = 0;
		while(total < n) {
			line ++;
			total += line;
		}

		//System.out.println(line);
		if(line%2 == 0) {
			System.out.println((n-total+line) + "/" + (total-n+1));
		}
		else {System.out.println((total-n+1) + "/" + (n-total+line));
		}
	}
}


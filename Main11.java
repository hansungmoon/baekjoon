package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main11 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Stack<Integer> stack = new Stack<Integer>();
		
		int n = Integer.parseInt(br.readLine());
		int f = 0;
		
		for(int i = 0; i < n;i++) {
			
			int num = Integer.parseInt(br.readLine());
			
			if(num > f) {
				for(int j = f+1;j <= num;j++) {
					stack.push(j);
					sb.append('+').append('\n');
				}
				f = num;
			}
			
			else if(num != stack.peek()) {
				System.out.println("NO");
				return;
			}
			
			stack.pop();
			sb.append('-').append('\n');
		}
		System.out.println(sb);
	}
}


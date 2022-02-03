package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main10 {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Integer> stack = new Stack<Integer>();
		int n = Integer.parseInt(br.readLine());
		
		for(int i =0;i < n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			String str = st.nextToken();
			
			if(str.equals("push")) {
				stack.push(Integer.parseInt(st.nextToken()));
			}
			else if(str.equals("pop")) {
				if(stack.empty()) {System.out.println((-1));}
				else {
					System.out.println(stack.peek());
					stack.pop();
				}
			}
			else if(str.equals("size")) {
				System.out.println(stack.size());
			}
			else if(str.equals("empty")) {
				if(stack.empty()) {System.out.println(1);}
				else {System.out.println(0);}
			}
			else if(str.equals("top")) {
				if(stack.empty()) {System.out.println(-1);}
				else {
					System.out.println(stack.peek());
				}
			}
		}
		//System.out.println("Å©±â : " + stack.size());
	}
}

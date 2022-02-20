package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main47 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashSet<String> list = new HashSet<String>();			//ArrayList에 비해 빠르다
		LinkedList<String> result = new LinkedList<String>();
		
		for(int i = 0;i < N;i++) {
			list.add(br.readLine());
		}
		
		
		for(int i = 0;i < M;i++) {
			String s = br.readLine();
			
			if(list.contains(s)) {			//듣도 못한 사람에 포함되어 있으면 
				result.add(s);
			}
		}
		
		result.sort(null);					// 오름차순 정렬
		
		StringBuilder sb = new StringBuilder();
		sb.append(result.size()).append("\n");
		
		for(int i = 0;i < result.size();i++) {
			sb.append(result.get(i)).append("\n");
		}
		
		System.out.println(sb);
	}
}

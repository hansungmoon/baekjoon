package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main43 {
	
	static boolean isNumber(String quiz) {
		for(int i = 0;i < quiz.length();i++) {
			if(!Character.isDigit(quiz.charAt(i))) {	//���ڿ� �ȿ� ���ڰ� �ִ��� �Ǻ�
				return false;		//���ڰ� ������ false ��ȯ
			}
		}
		return true;				//�ƴϸ� true ��ȯ
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();	//���ڿ��� ��û�Ҷ� ����� Map
		ArrayList<String> list = new ArrayList<String>();				//���ڸ� ��û�Ҷ� ����� �迭
		
		for(int i = 0;i < N;i++) {
			String s = br.readLine();
			map.put(s, i+1);			// ������ 1���� ���ڸ� ���Ƿ� i+1
			list.add(s);
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0;i < M;i++) {
			String quiz = br.readLine();
			if(isNumber(quiz)) {	//quiz�� �����̸�
				// �迭�� 0 ���� �����ϰ� ������ 1���� �����ϹǷ� quiz -1 
				sb.append(list.get(Integer.parseInt(quiz) - 1)).append("\n");
			}
			else {		//quiz�� �����̸�
				sb.append(map.get(quiz)).append("\n");
			}
		}
		System.out.println(sb);
	}
}

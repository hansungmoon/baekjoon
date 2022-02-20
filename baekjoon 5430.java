package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main48 {
	
	static StringBuilder sb = new StringBuilder();
	
	static void result(String p, Deque<Integer> deq) {
		boolean way = true;			// �迭�� ������ �Ǵ�
		
		for(int i = 0;i < p.length();i++) {
			if(p.charAt(i) == 'R') {		// �Լ��� ���ڰ� R�̸�
				way = !way;					// �迭 ������
			}
											// ���ڰ� D�϶�
			else {
				if(deq.isEmpty()) {			// ���� ��������� error
					sb.append("error\n");
					return;
				}
				if(way) {					// �������̸� ���� ù��° ����
					deq.removeFirst();
				}
				else {						// �������̸� ���� ������ ����
					deq.removeLast();
				}
			}
		}
		
		sb.append('[');						// ���� ����������� '['�� �־���ϹǷ�
		
		if(deq.size() > 0) {
			
			if(way) {						// �������϶�
				sb.append(deq.pollFirst());	// ù��°�� ������ ���� ���
				
				while(!deq.isEmpty()) {		// ���� �� ������
					sb.append(',').append(deq.pollFirst());	// ','�� ��� ù��°�� ������ ���� ���
				}
				
			}
			else {
				sb.append(deq.pollLast());
				
				while(!deq.isEmpty()) {
					sb.append(',').append(deq.pollLast());
				}
				
			}
			
		}
		sb.append("]\n");		// ���� ����������� ']'�� �־�� �ϹǷ�
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0;i < T;i++) {
			String p = br.readLine();		// ������ �Լ�
			int n = Integer.parseInt(br.readLine());		//�迭�� ��
			StringTokenizer st = new StringTokenizer(br.readLine(),"[],");	//'[]' ','�� �������� �и�
			
			Deque<Integer> deq = new LinkedList<Integer>();
			for(int j = 0;j < n;j++) {
				deq.add(Integer.parseInt(st.nextToken()));		//���� �и��� ���ڸ� �߰�
			}
			
			result(p, deq);
		}
		
		System.out.println(sb);
	}
}

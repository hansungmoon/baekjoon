package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main49 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> q = new PriorityQueue<Integer>();	//���� ���� ���� �������� �켱���� ť(�������� ����)
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0;i < N;i++) {
			int x = Integer.parseInt(br.readLine());
			if(x == 0) {			// 0�ϋ�
				if(q.isEmpty()) {	// ť�� ���������
					sb.append(0).append("\n");	// 0�� ���
				}
				else {
					sb.append(q.poll()).append("\n");	// ������� ������ ���� ���� �� ���
				}
			}
			else {
				q.add(x);			// �ڿ����� �� ť�� �߰�
			}
		}
		
		System.out.println(sb);
	}
}

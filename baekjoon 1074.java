package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main35 {
	static int count = 0;
	
	static void Counting(int size, int r, int c) {
		if(size == 1) {
			return;
		}
		
		int halfS = size / 2 ;
		
		if(r < halfS && c < halfS) {		// 1��и� �϶� ũ�⸸ / 2  
			Counting(halfS, r , c);
		}
		else if(r < halfS && c >= halfS) {	// 2��и� �϶� �� - ũ�� / 2 �ؼ� ���� 1��и� ������ ����
			count += size * size / 4;		// 1��и��� ��ŵ �����Ƿ� count�� ���� / 4 �� ���Ѵ�
			Counting(halfS, r, c - halfS);
		}
		else if(r >= halfS && c < halfS) {	// 3��и� �϶� �� - ũ�� / 2 �ؼ� ���� 1��и� ������ ����
			count += (size * size / 4) * 2;	// 1,2��и��� ��ŵ �����Ƿ� (count�� ���� / 4) * 2 �� ���Ѵ�
			Counting(halfS, r - halfS, c);
		}
		else if(r >= halfS && c>= halfS) {	// 4��и� �϶� �� - ũ�� / 2, �� - ũ�� / 2 �ؼ� ���� 1��и� ������ ����
			count += (size * size / 4) * 3;	// 1,2,3��и��� ��ŵ �����Ƿ� count�� (���� / 4) * 3 �� ���Ѵ�
			Counting(halfS, r - halfS, c - halfS);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());	//��
		int c = Integer.parseInt(st.nextToken());	//��
		int size = (int) Math.pow(2, N);			//�� ���� ����
		
		Counting(size, r, c);
		System.out.println(count);
	}
}

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main36 {
	//���ڸ� 0�� ������ n�� ���μ� �����Ͽ� 2�� 5�� ¦���� ���� ��ŭ
	//���丮�� ������ 2�� ������ 5�� �������� ����
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		
		while(n >= 5) {				//5�� ������ ���ϴ� �ݺ���
			count += n / 5;
			n /= 5;
		}
		System.out.println(count);
	}
}

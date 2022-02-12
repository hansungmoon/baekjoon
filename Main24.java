package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main24 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int buttonList = Integer.parseInt(br.readLine());

		ArrayList<Character> list = new ArrayList<Character>();		//���峭 ��ư �迭
		
		if(buttonList != 0) {										//���峭 ��ư�� ������ �Է¹��� ����
			
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
			for(int i = 0;i < buttonList;i++) {
				list.add(st.nextToken().charAt(0));		//String�� Character���� ��ȯ
			}
		}
		
		int buttonMove = Math.abs(n-100);			//ä�� 100 ���� ���� '+','-'�θ� ������ ��
		
		int min = 9999999;							//ä���� �ִ밪 : ���� ����� ä���� ã������ ��
		int count = 0;
		
		for(int i = 0;i < 1000000;i++) {			//��� ä�� ����Ž��
			String s = String.valueOf(i);			//i���� String���� ��ȯ
			boolean flag = true;					//���۵� ��ư�� üũ�ϴ� boolean
			
			for(int k = 0;k < s.length();k++) {
				if(list.contains(s.charAt(k))) {	//���۵� ��ư���ڰ� ���ԵǾ������� continue
					flag = false;
					break;
				}
			}
			if(flag == false) {	
				continue;
			}
			
			count = Math.abs(i - n) + s.length();
			
			if(count < min) {
				min = count;
			}
		}
		
		if(min < buttonMove) {
			System.out.println(min);
		}
		else {System.out.println(buttonMove);}
		
	}
}

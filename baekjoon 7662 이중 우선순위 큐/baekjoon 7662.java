package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main31 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			int k = Integer.parseInt(br.readLine());
			//TreeMap ���� �������� ���ĵǾ ����ȴ�, �ߺ� �ε��� �Ұ���
			TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
			
			for(int j = 0;j < k;j++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				String s = st.nextToken();
				int n = Integer.parseInt(st.nextToken());
				
				if(s.equals("I")) {
					map.put(n, map.getOrDefault(n, 0) +1);		// TreeMap�� �� ���� ���� �� �̸� value + 1 
				}
				else {											
					if(map.isEmpty()) {							// TreeMap�� ��������� ��ŵ	
						continue;
					}
					if(n == 1) {
						int key = map.lastKey();				// 1 �̸� �ִ�
						
						if(map.put(key, map.get(key)-1) == 1) {	// �ִ��� value�� -1�ؼ� put, -1 �ϱ��� value�� 1�̿�����
							map.remove(key);					// �ش� key ����
						}
					}
					else {										
						int key = map.firstKey();				// -1 �̸� �ּڰ�
						
						if(map.put(key, map.get(key)-1) == 1) {	// �ּڰ��� value�� -1�ؼ� put, -1 �ϱ��� value�� 1�̿�����
							map.remove(key);					// �ش� key ����
						}
					}
				}
			}
			if(map.isEmpty()) {
				System.out.println("EMPTY");
			}
			else {
				System.out.println(map.lastKey() + " " + map.firstKey());
			}
			
		}
	}
}

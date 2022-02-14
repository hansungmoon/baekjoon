package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main30 {
	static int[][] arr;									//��,���� ���ڷ� ���� �迭
	static StringBuilder sb = new StringBuilder();		
	
	static boolean pressureB(int x, int y, int size) {	//������ ��ŭ ���� ���ڷ� �̷���� �ִ��� �Ǻ�
		int startNum = arr[x][y];
		
		for(int i = x;i < size + x;i++) {
			
			for(int j = y;j < size + y;j++) {
				if(arr[i][j] != startNum) {
					return false;
				}
			}
		}
		return true;
	}
	
	//��� �Լ��� �̿��� QuadTree �˰���
	static void QuadTree(int x, int y,int size) {
		if(pressureB(x,y,size)) {					//size��ŭ�� ���� �����̸� ����
			sb.append(arr[x][y]);
			return;
		}
		
		int halfSize = size / 2;					//size�ȿ� �ٸ� ���ڰ� ���ԵǾ������� ������ ���δ�
		
		sb.append('(');								//����� ���������Ƿ� '('
		
		QuadTree(x, y, halfSize);							//1. ���� �� ����
		QuadTree(x, y + halfSize, halfSize);				//2. ������ �� ����
		QuadTree(x + halfSize, y, halfSize);				//3. ���� �Ʒ� ����
		QuadTree(x + halfSize, y + halfSize, halfSize);		//4. ������ �Ʒ� ����
		
		sb.append(')');
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		
		for(int i = 0;i < N;i++) {						//��,���� 1,0���� �޾Ƽ� �迭�� ����
			String st = br.readLine();
			for(int j = 0;j < N;j++) {
				arr[i][j] = st.charAt(j) - '0';
			}
		}
		
		QuadTree(0, 0, N);								//0,0���� ����
		System.out.println(sb);
		
	}
}

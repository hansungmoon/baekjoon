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
		
		if(r < halfS && c < halfS) {		// 1사분면 일때 크기만 / 2  
			Counting(halfS, r , c);
		}
		else if(r < halfS && c >= halfS) {	// 2사분면 일때 열 - 크기 / 2 해서 열을 1사분면 값으로 변경
			count += size * size / 4;		// 1사분면을 스킵 했으므로 count에 넓이 / 4 를 더한다
			Counting(halfS, r, c - halfS);
		}
		else if(r >= halfS && c < halfS) {	// 3사분면 일때 행 - 크기 / 2 해서 열을 1사분면 값으로 변경
			count += (size * size / 4) * 2;	// 1,2사분면을 스킵 했으므로 (count에 넓이 / 4) * 2 를 더한다
			Counting(halfS, r - halfS, c);
		}
		else if(r >= halfS && c>= halfS) {	// 4사분면 일때 행 - 크기 / 2, 열 - 크기 / 2 해서 열을 1사분면 값으로 변경
			count += (size * size / 4) * 3;	// 1,2,3사분면을 스킵 했으므로 count에 (넓이 / 4) * 3 를 더한다
			Counting(halfS, r - halfS, c - halfS);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());	//행
		int c = Integer.parseInt(st.nextToken());	//열
		int size = (int) Math.pow(2, N);			//한 변의 길이
		
		Counting(size, r, c);
		System.out.println(count);
	}
}

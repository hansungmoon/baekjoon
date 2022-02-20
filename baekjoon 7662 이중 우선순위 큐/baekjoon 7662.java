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
			//TreeMap 오름 차순으로 정렬되어서 저장된다, 중복 인덱스 불가능
			TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
			
			for(int j = 0;j < k;j++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				String s = st.nextToken();
				int n = Integer.parseInt(st.nextToken());
				
				if(s.equals("I")) {
					map.put(n, map.getOrDefault(n, 0) +1);		// TreeMap에 값 저장 같은 수 이면 value + 1 
				}
				else {											
					if(map.isEmpty()) {							// TreeMap이 비어있으면 스킵	
						continue;
					}
					if(n == 1) {
						int key = map.lastKey();				// 1 이면 최댓값
						
						if(map.put(key, map.get(key)-1) == 1) {	// 최댓값의 value를 -1해서 put, -1 하기전 value가 1이였으면
							map.remove(key);					// 해당 key 삭제
						}
					}
					else {										
						int key = map.firstKey();				// -1 이면 최솟값
						
						if(map.put(key, map.get(key)-1) == 1) {	// 최솟값의 value를 -1해서 put, -1 하기전 value가 1이였으면
							map.remove(key);					// 해당 key 삭제
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

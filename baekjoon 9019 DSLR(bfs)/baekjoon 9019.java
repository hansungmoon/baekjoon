import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            boolean[] visited = new boolean[10000];     //범위만큼 배열크기
            String[] DSLR = new String[10000];

            Queue<Integer> q = new LinkedList<>();
            q.add(A);
            visited[A] = true;

            Arrays.fill(DSLR, "");      // null값에 문자열 + 가 안되므로 빈문자열로 채움
            while (!q.isEmpty()) {   //큐가 빌 때 까지 반복
                if (visited[B]) {   // B가 방문처리되면 중단
                    break;
                }
                int now = q.poll();
                //각각 명령어의 값을 저장
                int D = now * 2 % 10000;
                int S = (now == 0) ? 9999 : now - 1;
                int L = now % 1000 * 10 + now / 1000;
                int R = now % 10 * 1000 + now / 10;

                // 각 명령어가 방문처리가 안되어있으면 현재 DSLR + 명령어
                if (!visited[D]) {
                    q.add(D);
                    visited[D] = true;
                    DSLR[D] = DSLR[now] + "D";
                }
                if (!visited[S]) {
                    q.add(S);
                    visited[S] = true;
                    DSLR[S] = DSLR[now] + "S";
                }
                if (!visited[L]) {
                    q.add(L);
                    visited[L] = true;
                    DSLR[L] = DSLR[now] + "L";
                }
                if (!visited[R]) {
                    q.add(R);
                    visited[R] = true;
                    DSLR[R] = DSLR[now] + "R";
                }
            }
            System.out.println(DSLR[B]);        // while문 끝나면 출력
        }
    }
}

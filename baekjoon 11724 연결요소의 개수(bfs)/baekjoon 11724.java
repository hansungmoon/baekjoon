import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main7 {
    static int[][] arr;     //인접행렬 배열
    static boolean[] visted;    //방문여부 배열

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);           //큐에 시작점 추가
        visted[start] = true;   //방문 처리

        while (!q.isEmpty()) {  //큐가 빌때 까지 반복
            int qNum = q.poll();    //큐에서 하나 비우고 변수에 저장

            for(int i = 1; i < arr.length;i++) {
                if (arr[qNum][i] == 1 && !visted[i]) {
                    q.add(i);               //조건이 맞으면 큐에 추가
                    visted[i] = true;       //방문처리
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][N + 1];        //index 0은 안쓰므로 + 1
        visted = new boolean[N + 1];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            arr[u][v] = 1;      //인접행렬 배열 0 -> 1
            arr[v][u] = 1;
        }

        int count = 0;

        for(int i = 1; i <= N; i++) {   //모든 정점을 시작점으로
            if (!visted[i]) {       //방문한 적이 없는 정점이면
                bfs(i);             //bfs 실행
                count++;
            }
        }

        System.out.println(count);
    }
}

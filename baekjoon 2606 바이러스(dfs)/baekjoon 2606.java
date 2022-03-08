import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    static boolean[] visited;   // 방문여부 배열
    static int [][] computer;   // 인접행렬 배열
    static int count = 0;

    static int dfs(int start) {
        visited[start] = true;

        for (int i = 1; i < computer.length; i++) {

            if(!visited[i] && computer[start][i] == 1) {    // 방문한적없고, 이어져 있으면
                count++;        // 이어진게 있으면 count + 1
                dfs(i);         // 재귀
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];       //Index 0은 쓰지 않아서 배열 크기 +1
        computer = new int[N+1][N+1];

        for(int i = 1;i <= M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            computer[n1][n2] = 1;           //인접 행렬 입력
            computer[n2][n1] = 1;
        }

        System.out.println(dfs(1));

    }
}

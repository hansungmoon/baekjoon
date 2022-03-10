import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        LinkedList<Integer> list = new LinkedList<>();

        for(int i = 0;i < N;i++) {
            int n = Integer.parseInt(st.nextToken());
            list.add(n);
        }

        // 걸리는 시간이 작은 사람이 먼저 이므로
        list.sort(null);            // 오름차순으로 정렬

        int result = 0;               // 최종 합
        int sum = 0;                  // 누적 값

        for(int i = 0; i < list.size(); i++) {
            result += sum + list.get(i);

            sum += list.get(i);
        }

        System.out.println(result);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());    // 회의의 수

        int[][] arr = new int[N][2];                // 회의 시간을 받을 배열

        for(int i = 0;i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());   // 회의 시작시간
            arr[i][1] = Integer.parseInt(st.nextToken());   // 회의 종료시간

        }

        Comparator<int[]> asc = (int[] o1, int[] o2) -> {

            if(o1[1] == o2[1]) {            //  회의종료 시간이 같으면 시작시간을 기준으로 오름차순
                return o1[0] - o2[0];
            }

            return o1[1] - o2[1];           // 회의 종료시간을 기준으로 오름차순
        };

        Arrays.sort(arr, asc);              //회의시간을 오름차순 정렬


        int count = 0;
        int endTime = 0;                    // 현재 회의 종료 시간

        for(int i = 0; i < N;i++) {
            // 종료시간 기준으로 정렬했기 때문에 가능
            if(endTime <= arr[i][0]) {      // 종료시간이 다음 회의 시작시간 이하 이면
                endTime = arr[i][1];        // 종료시간을 다음 회의 종료시간으로 변경
                count++;
            }
        }

        System.out.println(count);
    }
}

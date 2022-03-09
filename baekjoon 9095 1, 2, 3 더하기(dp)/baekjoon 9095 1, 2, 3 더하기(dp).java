import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[] arr = new int[11];
        arr[1] = 1;     // (1)
        arr[2] = 2;     // (1+1, 2)
        arr[3] = 4;     // (1+1+1, 1+2, 2+1, 3)

        for(int i = 0;i < T;i++) {
            int n = Integer.parseInt(br.readLine());

            for(int j = 4;j <= n;j++) {
                // ex) 4일때 3 + 2 + 1의 경우의 수가 같다
                // n까지 dp를 채운다
                arr[j] = arr[j - 1] + arr[j - 2] + arr[j - 3];
            }
            System.out.println(arr[n]);
        }
    }
}

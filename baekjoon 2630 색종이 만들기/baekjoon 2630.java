import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3 {
    static int[][] arr;         // 색을 0과 1로 받을 배열
    static int white = 0;
    static int blue = 0;

    static boolean sameColor(int x, int y, int size) {

        int startColor = arr[x][y];             //시작점 색깔 변수

        for(int i = x; i < size + x ;i++) {
            for(int j = y; j < size + y ;j++) {

                if(arr[i][j] != startColor) {   // 사이즈 안에 다른색깔 있으면 false
                    return false;
                }
            }
        }
        return true;        //사이즈 안이 모두 같은 색이면 trues
    }

    static void QuadTree(int x, int y, int size) {

        if(sameColor(x, y, size)) {             // size 안이 모두 같은 색인지 판별
            if(arr[x][y] == 0) {white++;}       // 같은 색이고 0으로 이루어져 있으면
            else {blue++;}
            return;                             // 재귀 종료
        }

        int halfSize = size / 2;                // 크기를 줄여서 재귀

        QuadTree(x, y, halfSize);                   // 왼쪽 위
        QuadTree(x, y + halfSize, halfSize);        //오른쪽 위
        QuadTree(x + halfSize, y, halfSize);        //왼쪽 아래
        QuadTree(x + halfSize, y + halfSize, halfSize);     //오른쪽 아래

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N][N];            //한변의 길이 : 배열 크기

        for(int i = 0;i < N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for(int j = 0; j < N;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());   //배열에 1, 0 담기
            }
        }

        QuadTree(0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }
}

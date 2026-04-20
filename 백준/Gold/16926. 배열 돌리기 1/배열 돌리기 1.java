import java.util.*;
import java.io.*;

public class Main{
    private static int N, M;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static int[][] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(r-- > 0){
            rotate();
        }

        StringBuilder sb = new StringBuilder();
        for(int[] x: arr){
            for(int i : x){
                sb.append(i).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static void rotate(){
        // 1회에 돌아가는 블럭
        // min (N, M) / 2
        for(int b = 0; b < Math.min(N, M) / 2; b++){
            int tmp = arr[b][b];

            int x = b, y = b, d = -1;
            while(++d < 4){
                while(true){
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if(nx < 0 + b | nx >= N - b | ny < 0 + b | ny >= M - b){
                        break;
                    }

                    arr[x][y] = arr[nx][ny];
                    x = nx; y = ny;
                }
            }
            
            arr[b+1][b] = tmp;
        }
    }
}
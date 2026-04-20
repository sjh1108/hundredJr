import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    public static void main(String[] args) throws IOException{

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());

        boolean[][] arr = new boolean[N][M];
        
        arr[0][0] = true;
        int cnt = 0;
        int dir = 0;
        int chk = 1;
        
        int x = 0, y = 0;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1 ,0};

        while(true){
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if(nx < 0 || nx >= N || ny < 0 || ny >= M || arr[nx][ny]){
                dir = (dir + 1) % 4;
                cnt++;
                continue;
            }

            x = nx; y = ny;
            arr[nx][ny] = true;
            chk++;

            if(chk == N*M) break;
        }

        System.out.println(cnt);
    }
}
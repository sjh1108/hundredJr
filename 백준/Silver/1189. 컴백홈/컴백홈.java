import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, K;

    static int cnt = 0;
    static int[][] arr;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0 ,0};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                if(str.charAt(j) == 'T') arr[i][j] = -1;
            }
        }
        arr[N - 1][0] = 1;

        dfs(N - 1, 0);

        System.out.println(cnt);
    }
    static void dfs(int x, int y){
        if(x == 0 && y == M - 1){
            if(arr[x][y] == K) cnt++;
            return;
        }

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

            if(arr[nx][ny] == 0){
                arr[nx][ny] = arr[x][y] + 1;
                dfs(nx, ny);
                arr[nx][ny] = 0;
            }
        }
    }
}
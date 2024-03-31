import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    static int[][] arr;
    static boolean[][] cheeze, visited;
    static int cnt = 0;
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        cheeze = new boolean[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());

                if(arr[i][j] == 1){
                    cheeze[i][j] = true;
                    cnt++;
                }
            }
        }


        int time = 0;
        while(cnt > 0){
            visited = new boolean[N][M];
            time++;
            int[] dx = {0, 0, N-1, N-1};
            int[] dy = {0, M-1, 0, M-1};

            for(int i = 0; i < 4; i++){
                dfs(dx[i], dy[i]);
            }

            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(cheeze[i][j]){
                        melt(i, j);
                    }
                }
            }
        }

        System.out.println(time);
    }

    static void dfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        arr[x][y] = 2;

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if(visited[nx][ny] || cheeze[nx][ny]) continue;

            dfs(nx, ny);
        }
    }

    static void melt(int x, int y){
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        int air = 0;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if(arr[nx][ny] == 2) air++;
        }

        if(air >= 2){
            cheeze[x][y] = false;
            cnt--;
        }
    }
}
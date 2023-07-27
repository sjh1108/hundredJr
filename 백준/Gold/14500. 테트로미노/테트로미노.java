import java.util.*;
import java.io.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N, M;
    static int arr[][];
    static boolean visited[][];

    static int max;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        max = 0;
outLoop:for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                visited[i][j] = true;

                DFS(i, j, 0, 0);
                if(max == 4000){
                    break outLoop;
                }

                visited[i][j] = false;
            }
        }

        System.out.println(max);
    }

    static void DFS(int x, int y, int sum, int count){
        if(count == 4){
            max = Math.max(max, sum);
            return;
        }
        if(count == 1){
            boolean zf[] = new boolean[4];
            int zcnt = 0;
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i]; int ny = y + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M){
                    zf[i] = true;
                }

                if(zf[i]){
                    zcnt++;
                }
            }

            if(zcnt == 0){
                int sum1 = arr[x][y] + arr[x + dx[0]][y + dy[0]] + arr[x + dx[1]][y + dy[1]] + arr[x + dx[2]][y + dy[2]] + arr[x + dx[3]][y + dy[3]];
                for(int i = 0; i < 4; i++){
                    int nx = x + dx[i]; int ny = y + dy[i];

                    sum1 -= arr[nx][ny];
                    max = Math.max(max, sum1);
                    sum1 += arr[nx][ny];
                }
            }

            if(zcnt == 1){
                int sum1 = arr[x][y];

                for(int i = 0; i < 4; i++){
                    int nx = x + dx[i]; int ny = y + dy[i];
                    if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                    sum1 += arr[nx][ny];
                }

                max = Math.max(max, sum1);
            }
        }
        
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i]; int ny = y + dy[i];
            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            if(visited[nx][ny]) continue;
            
            visited[nx][ny] = true;
            DFS(nx, ny, sum + arr[nx][ny], count + 1);
            visited[nx][ny] = false;
        }

    }
}
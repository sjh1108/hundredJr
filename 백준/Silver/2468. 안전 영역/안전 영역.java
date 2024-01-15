import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    static int[][] map = new int[N][N];
    static boolean[][] visited = new boolean[N][N];
    public static void main(String[] args) throws IOException{

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        int max = 0;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
            }
        }

        int answer = 0;
        
        for(int height = 0; height <= max; height++){

            int cnt = 0;
            visited = new boolean[N][N];

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(map[i][j] < height && !visited[i][j]){
                        visited[i][j] = true;
                    }
                }
            }

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(!visited[i][j]){
                        cnt++;
                        dfs(i, j);
                    }
                }
            }

            answer = Math.max(answer, cnt);
        }

        System.out.println(answer);

    }

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0 ,0};
    static void dfs(int x, int y){
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i]; int ny = y + dy[i];

            if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            if(visited[nx][ny]) continue;

            visited[nx][ny] = true;

            dfs(nx, ny);
        }
    }
}
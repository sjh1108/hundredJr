import java.io.*;
import java.util.*;

public class Main{
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N, M, K;

    static int count = 0;
    
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int[][] map;
    static boolean[][] visited;
    static boolean[][] finished;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i = 0; i < N; i++){
            String s = br.readLine();

            for(int j = 0; j < M; j++){
                char c = s.charAt(j);
                
                if(c == 'U') map[i][j] = 0;
                else if(c == 'R') map[i][j] = 1;
                else if(c == 'D') map[i][j] = 2;
                else if(c == 'L') map[i][j] = 3;
            }
        }

        visited = new boolean[N][M];
        finished = new boolean[N][M];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(!visited[i][j]) dfs(i, j);
            }
        }

        System.out.println(count);
    }

    static void dfs(int x, int y){
        visited[x][y] = true;

        int nx = x + dx[map[x][y]];
        int ny = y + dy[map[x][y]];

        if(nx < 0 || nx >= N || ny < 0 || ny >= M){
            dfs(x, y);
            return;
        }
        if(!visited[nx][ny]){
            dfs(nx, ny);
        } else {
            if(!finished[nx][ny]) count++;
        }

        finished[x][y] = true;
    }
}
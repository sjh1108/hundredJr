import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    static class Point{
        int x, y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    static boolean[][] visited;
    static int[] area = new int[10000];
    

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); N = Integer.parseInt(st.nextToken());
        int blockCount = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1][M + 1];

        while(blockCount-- > 0){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()); int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken()); int y2 = Integer.parseInt(st.nextToken());

            for(int i = x1; i < x2; i++){
                for(int j = y1; j < y2; j++){
                    visited[i][j] = true;
                }
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(visited[i][j]) continue;
                area[ans++] = dfs(i, j, 1);
            }
        }
        area = Arrays.copyOfRange(area, 0, ans);
        Arrays.sort(area);
        sb.append(ans).append("\n");
        for(int i = 0; i < ans; i++){
            sb.append(area[i]).append(" ");
        }
        System.out.println(sb);
    }

    static int ans = 0;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0 ,0};

    static int dfs(int x, int y, int cnt){
        visited[x][y] = true;

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i]; int ny = y + dy[i];
            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            if(visited[nx][ny]) continue;
            cnt = dfs(nx, ny, cnt + 1);
        }

        return cnt;
    }
}
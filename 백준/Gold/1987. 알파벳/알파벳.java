import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    static int max = 0;
    static int[][] map;
    static boolean[][] visited;
    static boolean[] alpha = new boolean[26]; // 알파벳 사용 여부

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M]; visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = str.charAt(j) - 'A';
            }
        }

        visited[0][0] = true; alpha[map[0][0]] = true;
        dfs(0, 0, 1);
        System.out.println(max);
    }

    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    static void dfs(int x, int y, int cnt){
        max = Math.max(max, cnt);

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            if(visited[nx][ny] || alpha[map[nx][ny]]) continue;

            visited[nx][ny] = true; alpha[map[nx][ny]] = true; cnt++;

            dfs(nx, ny, cnt--);
            
            visited[nx][ny] = false; alpha[map[nx][ny]] = false;
        }
    }
}
import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;

    static int[][] map;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(max);
    }

    static void dfs(int x, int cnt){
        if(cnt == 3){
            bfs();
            return;
        }

        for(int i = x; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    dfs(i, cnt + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static void bfs(){
        int[][] copyMap = new int[N][M];

        for(int i = 0; i < N; i++){
            copyMap[i] = map[i].clone();
        }

        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(copyMap[i][j] == 2){
                    q.offer(new int[]{i, j});
                }
            }
        }

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < N && ny < M){
                    if(copyMap[nx][ny] == 0){
                        copyMap[nx][ny] = 2;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        int cnt = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(copyMap[i][j] == 0){
                    cnt++;
                }
            }
        }

        max = Math.max(max, cnt);
    }
}
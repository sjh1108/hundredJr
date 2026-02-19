import java.io.*;
import java.util.*;

class Main {
    private static int N, M;
    private static int cnt;

    private static int[] dx = {-1, 0, 1};
    private static boolean[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new boolean[N][M];
        
        for(int i = 0; i < N; i++){
            char[] input = br.readLine().toCharArray();
            for(int j = 0; j < M; j++){
                if(input[j] == 'x') map[i][j] = true;
            }
        }

        cnt = 0;
        for(int i = 0; i < N; i++) if(!map[i][0]) dfs(i, 0);

        System.out.println(cnt);
    }

    private static boolean dfs(int x, int y){
        map[x][y] = true;

        if(y == M-1){
            cnt++;
            return true;
        }

        for(int d = 0; d < 3; d++){
            int nx = x + dx[d];
            int ny = y + 1;

            if(!isIn(nx, ny)) continue;
            if(map[nx][ny]) continue;
            if(dfs(nx, ny)) return true;
        }

        return false;
    }
    
    private static boolean isIn(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}

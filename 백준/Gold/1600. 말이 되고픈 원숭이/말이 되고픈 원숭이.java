import java.io.*;
import java.util.*;

class Main {
    private static int W, H;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        int[][] map = new int[H][W];
        boolean[][][] visited = new boolean[H][W][31];
        for(int i = 0; i < H; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < W; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, -1, 0, 1};
        
        int[] hx = new int[]{-2, -2, -1, 1, 2, 2, 1, -1};
        int[] hy = new int[]{-1, 1, 2, 2, 1, -1, -2, -2};
        
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0, 0, K});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], cnt = cur[2], horse = cur[3];

            if(x == H - 1 && y == W - 1) {
                System.out.println(cnt);
                return;
            }

            for(int d = 0; d < 4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];

                if(isIn(nx, ny) && map[nx][ny] == 0 && !visited[nx][ny][horse]){
                    visited[nx][ny][horse] = true;
                    q.add(new int[]{nx, ny, cnt + 1, horse});
                }
            }

            if(horse > 0){
                for(int d = 0; d < 8; d++){
                    int nx = x + hx[d];
                    int ny = y + hy[d];

                    if(isIn(nx, ny) && map[nx][ny] == 0 && !visited[nx][ny][horse - 1]){
                        visited[nx][ny][horse - 1] = true;
                        q.add(new int[]{nx, ny, cnt + 1, horse - 1});
                    }
                }
            }
        }

        System.out.println(-1);
    }

    private static boolean isIn(int x, int y){
        return x >= 0 && x < H && y >= 0 && y < W;
    }
}
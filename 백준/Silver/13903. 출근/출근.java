import java.io.*;
import java.util.*;

class Main {
    private static int R, C;

    private static boolean isIn(int x, int y){
        return x >= 0 && x < R && y >= 0 && y < C;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        Queue<int[]> q = new ArrayDeque<>();
        int[][] map = new int[R][C];
        for(int i = 0; i < R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < C; i++){
            if(map[0][i] == 1){
                q.add(new int[]{0, i});
            }
        }

        int c = Integer.parseInt(br.readLine());
        int[][] cmdArray = new int[c][2];
        for(int i = 0; i < c; i++){
            st = new StringTokenizer(br.readLine());
            cmdArray[i][0] = Integer.parseInt(st.nextToken());
            cmdArray[i][1] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        boolean[][] visited = new boolean[R][C];
        while(!q.isEmpty()){
            int size = q.size();

            while(size-- > 0){
                int[] cur = q.poll();

                int x = cur[0];
                int y = cur[1];

                if(visited[x][y]) continue;
                visited[x][y] = true;

                if(cur[0] == R-1){
                    System.out.println(cnt);
                    return;
                }
                for(int[] cmd: cmdArray){
                    int nx = x + cmd[0];
                    int ny = y + cmd[1];

                    if(!isIn(nx, ny)) continue;
                    if(map[nx][ny] == 0 || visited[nx][ny]) continue;

                    q.add(new int[]{nx, ny});
                }
            }

            ++cnt;
        }

        System.out.println(-1);
    }
}
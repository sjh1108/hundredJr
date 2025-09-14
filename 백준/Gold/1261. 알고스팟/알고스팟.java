import java.io.*;
import java.util.*;

class Main {
    private static int N, M;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }

        boolean[][] visited = new boolean[N][M];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        pq.add(new int[]{0, 0, 0});
        visited[0][0] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while(!pq.isEmpty()){
            int[] cur = pq.poll();

            int x = cur[0];
            int y = cur[1];
            int t = cur[2];

            if(x == N-1 && y == M-1){
                System.out.println(t);
                return;
            }
            
            for(int d = 0; d < 4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];
                
                if(!isIn(nx, ny)) continue;
                if(visited[nx][ny]) continue;

                visited[nx][ny] = true;

                pq.add(new int[]{nx, ny, t + map[nx][ny]});
            }
        }
    }
    private static boolean isIn(int x, int y){
        return (x >= 0 && x < N) && (y >= 0 && y < M);
    }
}

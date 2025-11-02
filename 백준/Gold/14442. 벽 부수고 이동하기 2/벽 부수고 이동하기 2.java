import java.io.*;
import java.util.*;

class Main {
    private static final int INF = 1 << 20;
    private static int N, M, K;

    private static char[][] map;

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for(int i = 0; i < N; i++){
            map[i] = br.readLine().toCharArray();
        }

        int[][][] dist = new int[N][M][K+1];
        for(int[][] a : dist){
            for(int[] b: a){
                Arrays.fill(b, INF);
            }
        }
        
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0, 0, 1});

        while(!q.isEmpty()){
            int[] cur = q.poll();

            int x = cur[0];
            int y = cur[1];
            int cnt = cur[2];
            int cost = cur[3];

            if(dist[x][y][cnt] != INF) continue;

            dist[x][y][cnt] = cost;
            for(int d = 0; d < 4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];

                if(!isIn(nx, ny)) continue;

                if(map[nx][ny] == '0'){
                    q.add(new int[]{nx, ny, cnt, cost+1});
                    continue;
                } else{
                    if(cnt == K) continue;
                    
                    q.add(new int[]{nx, ny, cnt+1, cost+1});
                }
            }
        }

        int min = INF;
        for(int cnt = 0; cnt <= K; cnt++){
            min = Math.min(dist[N-1][M-1][cnt], min);
        }

        System.out.println(min == INF ? -1 : min);
    }

    private static boolean isIn(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
import java.io.*;
import java.util.*;

class Main {
    private static int N, M;

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];

        for(int i = 0; i < N; i++){
            map[i] = br.readLine().toCharArray();
        }

        int INF = 1_000_000;
        int[][][] arr = new int[N][M][K+1];

        for(int[][] ar: arr){
            for(int[] a: ar){
                Arrays.fill(a, INF);
            }
        }

        arr[0][0][0] = 1;

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0, 0});

        while(!q.isEmpty()){
            int[] cur = q.poll();

            int x = cur[0], y = cur[1], k = cur[2];

            if(x == N-1 && y == M-1){
                System.out.println(arr[x][y][k]);
                return;
            }

            for(int d = 0; d < 4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(!isIn(nx, ny)) continue;

                int nk = k + (map[nx][ny] == '1' ? 1 : 0);
                if(nk > K || arr[nx][ny][nk] != INF) continue;

                arr[nx][ny][nk] = arr[x][y][k] + 1;
                q.add(new int[]{nx, ny, nk});
            }
        }

        System.out.println(-1);
    }

    private static boolean isIn(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
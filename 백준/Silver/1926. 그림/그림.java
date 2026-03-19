import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int[][] map;
    private static boolean[][] visited;

    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        map = new int[N = Integer.parseInt(st.nextToken())][M = Integer.parseInt(st.nextToken())];
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0) visited[i][j] = true;
            }
        }

        int cnt = 0;
        int max = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(visited[i][j]) continue;
                cnt++;
                max = Math.max(max, BFS(i, j));
            }
        }

        System.out.println(cnt);
        System.out.println(max);
    }

    private static int BFS(int i, int j){
        int sum = 0;

        Queue<int[]> q = new LinkedList<>(); 

        q.add(new int[] {i, j});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            int x = cur[0], y = cur[1];
            if(visited[x][y]) continue;
            visited[x][y] = true;
            sum++;

            for(int d = 0; d < 4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];
    
                if(nx < 0 | nx > N-1 | ny < 0 | ny > M-1) continue;
                if(visited[nx][ny]) continue;

                q.add(new int[]{nx, ny});
            }
        }

        return sum;
    }
}

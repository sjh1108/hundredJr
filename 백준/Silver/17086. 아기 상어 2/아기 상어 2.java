import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int max = 0;

    private static int[] dist;
    private static int[][] map;
    private static boolean[][] visited;

    private static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    private static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

    private static List<int[]> list;

    private static void getMax(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                max = Math.max(map[i][j], max);
            }
        }
    }
    private static boolean isIn(int x, int y){
        return (x >= 0 && x < N) && (y >= 0 && y < M);
    }
    private static void bfs(){
        Queue<int[]> q = new ArrayDeque<>(list);

        while(!q.isEmpty()){
            int[] cur = q.poll();

            int x = cur[0];
            int y = cur[1];

            for(int d = 0; d < 8; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];

                if(!isIn(nx, ny)) continue;
                if(visited[nx][ny]) continue;

                visited[nx][ny] = true;
                int time = cur[2] + 1;
                map[nx][ny] = time;

                q.add(new int[]{nx, ny, time});
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();

        map = new int[N][M];
        visited = new boolean[N][M];
        
        int idx = 1;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                int tmp = Integer.parseInt(st.nextToken());
                
                if(tmp == 1){
                    list.add(new int[]{i, j, 0});
                    visited[i][j] = true;
                    idx++;

                    tmp = -1;
                }
                map[i][j] = tmp;
            }
        }
        dist = new int[idx];
        Arrays.fill(dist, -1);
        
        for(int i = 1; i < idx; i++){
            bfs();
        }

        getMax();
        System.out.println(max);
    }
}
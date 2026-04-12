import java.io.*;
import java.util.*;

class Main {
    private static int W, H;

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};

    private static int[] C;
    private static char[][] map;
    private static int[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        int temp = 0;
        C = new int[4];
        map = new char[H][W];
        visited = new int[H][W][4];
        for(int i = 0; i < H; i++){
            map[i] = br.readLine().toCharArray();

            for(int j = 0; j < W; j++){
                if(map[i][j] == 'C'){
                    C[temp++] = i;
                    C[temp++] = j;
                }
                Arrays.fill(visited[i][j], Integer.MAX_VALUE);
            }
        }

        System.out.println(bfs());
    }

    private static int bfs(){
        Deque<int[]> dq = new ArrayDeque<>();

        for(int d = 0; d < 4; d++){
            visited[C[0]][C[1]][d] = 0;
            dq.addFirst(new int[]{C[0], C[1], d, 0});
        }

        while(!dq.isEmpty()){
            int[] cur = dq.pollFirst();
            int x = cur[0], y = cur[1], dir = cur[2], cost = cur[3];

            if(x == C[2] && y == C[3]) return cost;
            if(cost > visited[x][y][dir]) continue;

            for(int d = 0; d < 4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];

                if(!isIn(nx, ny) || map[nx][ny] == '*') continue;

                int ncost = cost + (d != dir ? 1 : 0);
                if(ncost < visited[nx][ny][d]){
                    visited[nx][ny][d] = ncost;
                    if(d != dir){
                        dq.addLast(new int[]{nx, ny, d, ncost});
                    } else {
                        dq.addFirst(new int[]{nx, ny, d, ncost});
                    }
                }
            }
        }
        return -1;
    }

    private static boolean isIn(int x, int y){
        return x >= 0 && x < H && y >= 0 && y < W;
    }
}
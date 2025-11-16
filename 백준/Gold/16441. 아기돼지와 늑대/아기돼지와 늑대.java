import java.io.*;
import java.util.*;

class Main {
    private static int N, M;

    private static char[][] map;
    private static boolean[][] visited;

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};
    private static List<int[]> W;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];

        W = new ArrayList<>();
        for(int i = 0; i < N; i++){
            map[i] = br.readLine().toCharArray();

            for(int j = 0; j < M; j++){
                if(map[i][j] == 'W'){
                    W.add(new int[]{i, j});
                } else if(map[i][j] == '#'){
                    visited[i][j] = true;
                }
            }
        }

        Queue<int[]> q = new ArrayDeque<>(W);

        while(!q.isEmpty()){
            int[] cur = q.poll();

            int x = cur[0], y = cur[1];
            if(visited[x][y]) continue;
            visited[x][y] = true;

            for(int d = 0; d < 4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];

                if(!isIn(nx, ny) || visited[nx][ny]) continue;
                
                if(map[nx][ny] == '+'){
                    while(true){
                        nx += dx[d];
                        ny += dy[d];

                        if(!isIn(nx, ny) || map[nx][ny] == '#'){
                            nx -= dx[d];
                            ny -= dy[d];
                            break;
                        }
                        else if(map[nx][ny] == '.') break;
                    }
                }
                
                q.add(new int[]{nx, ny});
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] =='.' && !visited[i][j]){
                    map[i][j] = 'P';
                }
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    private static boolean isIn(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
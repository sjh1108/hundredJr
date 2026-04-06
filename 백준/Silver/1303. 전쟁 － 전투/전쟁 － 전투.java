import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] map = new char[M][];
        for(int i = 0; i < M; i++){
            map[i] = br.readLine().toCharArray();
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        boolean[][] visited = new boolean[M][N];

        int black = 0, white = 0;
        Queue<int[]> q = new ArrayDeque<>();
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(visited[i][j]) continue;

                char c = map[i][j];

                int cnt = 0;
                q.add(new int[]{i, j});
                while(!q.isEmpty()){
                    int[] cur = q.poll();

                    int x = cur[0], y = cur[1];
                    
                    if(visited[x][y]) continue;
                    visited[x][y] = true;
                    cnt++;

                    for(int d = 0; d < 4; d++){
                        int nx = x + dx[d];
                        int ny = y + dy[d];

                        if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                        if(visited[nx][ny]) continue;
                        if(map[nx][ny] != c) continue;

                        q.add(new int[]{nx, ny});
                    }
                }

                cnt *= cnt;

                if(c == 'W') white += cnt;
                else black += cnt;
            }
        }

        System.out.println(white + " " + black);
    }
}
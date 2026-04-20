import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    
    static boolean[][][] visited;
    static int[][] map;
    static int ans = -1;
    static int[] dx = { 1, -1, 0, 0};
    static int[] dy = { 0, 0, 1, -1};
    
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M][2];
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }
        BFS();
        System.out.println(ans);
    }

    static void BFS(){
        LinkedList<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1, 0});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int cnt = cur[2];
            int wall = cur[3];

            if(x == N - 1 && y == M - 1){
                ans = cnt;
                return;
            }   

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                if(map[nx][ny] == 0){
                    if(!visited[nx][ny][wall]){
                        if(wall == 0){
                            q.add(new int[]{nx, ny, cnt + 1, wall});
                            visited[nx][ny][wall] = true;
                        }
                        else{
                            q.add(new int[]{nx, ny, cnt + 1, wall});
                            visited[nx][ny][wall] = true;
                        }
                    }
                } else{
                    if(!visited[nx][ny][wall]){
                        if(wall == 0){
                            q.add(new int[]{nx, ny, cnt + 1, wall + 1});
                            visited[nx][ny][wall] = true;
                        }
                    }
                }
            }
        }
    }
}

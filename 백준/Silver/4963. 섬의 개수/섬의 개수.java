import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException{

        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        while(N != 0 && M != 0){
            map = new int[N][M];
            visited = new boolean[N][M];

            for(int i = 0 ; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0 ; j < M; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append(bfs()).append("\n");

            st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
        }

        System.out.println(sb);
    }

    static int[] dx = {-1, 0, 1, 0, -1, -1, 1, 1};
    static int[] dy = {0, -1, 0, 1, -1, 1, -1, 1};

    static int bfs(){
        int cnt = 0;

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(!visited[i][j] && map[i][j] == 1){
                    cnt++;
                    visited[i][j] = true;

                    q.offer(new int[]{i, j});
                    while(!q.isEmpty()){
                        int[] cur = q.poll();

                        for(int k = 0 ; k < 8 ; k++){
                            int nx = cur[0] + dx[k];
                            int ny = cur[1] + dy[k];

                            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                            if(!visited[nx][ny] && map[nx][ny] == 1){
                                visited[nx][ny] = true;
                                q.offer(new int[]{nx, ny});
                            }
                        }

                    }
                }
            }
        }

        return cnt;
    }
}
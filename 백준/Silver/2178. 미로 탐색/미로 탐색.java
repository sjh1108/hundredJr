import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, K;
    static int[] arr;

    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i = 0; i < N; i++){
            String s = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }

        visited = new boolean[N][M];
        visited[0][0] = true;

        bfs(0, 0);
        System.out.println(map[N - 1][M - 1]);
    }

    public static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y});

        while(!q.isEmpty()){
            int now[] = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for(int i = 0; i < 4; i++){
                int neX = nowX + dx[i];
                int neY = nowY + dy[i];

                if(neX < 0 || neY < 0 || neX >= N || neY >= M){
                    continue;
                }
                if(visited[neX][neY] || map[neX][neY] == 0){
                    continue;
                }

                q.add(new int[] {neX, neY});

                map[neX][neY] = map[nowX][nowY] + 1;
                visited[neX][neY] = true;
            }
        }
    }
}
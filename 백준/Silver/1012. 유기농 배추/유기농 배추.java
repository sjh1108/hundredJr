import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int M;
    static int K;

    static int[] arr;

    static int[][] cabbage;
    static boolean[][] visit;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException{
        K = Integer.parseInt(br.readLine());

        while(K-- > 0){
            st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            cabbage = new int[M][N];
            visit = new boolean[M][N];
            int k = Integer.parseInt(st.nextToken());

            while(k-- > 0){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                cabbage[x][y] = 1;
            }

            int count = 0;

            for(int i = 0; i < M; i++){
                for(int j = 0; j < N; j++){
                    if(cabbage[i][j] == 1 && !visit[i][j]){
                        dfs(i, j);
                        count++;
                    }
                }
            }

            sb.append(count).append('\n');
        }

        System.out.println(sb);
    }

    static void dfs(int x, int y){
        visit[x][y] = true;

        for(int i = 0; i < 4; i++){
            int cx = x + dx[i];
            int cy = y + dy[i];

            if(cx >= 0 && cy >= 0 && cx < M && cy < N){
                if (!visit[cx][cy] && cabbage[cx][cy] == 1) {
					dfs(cx, cy);
				}
            }
        }
    }
}
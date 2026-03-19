import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, K;
    static int[] arr;

    static boolean[] visit;
    static int[][] map;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        int link = Integer.parseInt(br.readLine());

        K = 1;

        map = new int[N + 1][N + 1];
        visit = new boolean[N + 1];

        while(link-- > 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = map[b][a] = 1;
        }

        System.out.println(dfs(1));
    }

    static int dfs(int n){
        visit[n] = true;

        for(int i = 0; i <= N; i++){
            if(map[n][i] == 1 && visit[i] != true){
                M++;
                dfs(i);
            }
        }

        return M;
    }
}
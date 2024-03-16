import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;
    static boolean[][] map;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new boolean[N][N * 2];

        dfs(0, N-1, N);
        for(int i = 0; i < N; i++){
            for(int j = 0; j < 2 * N; j++){
                if(map[i][j]) sb.append("*");
                else sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int x, int y, int n){        
        if (n == 3) {
            map[x][y] = true;
            map[x + 1][y - 1] = map[x + 1][y + 1] = true;
            map[x + 2][y - 2] = map[x + 2][y - 1] = map[x + 2][y] = map[x + 2][y + 1] = map[x + 2][y + 2] = true;
            return;
        }

        dfs(x, y, n / 2);
        dfs(x + n / 2, y - n / 2, n / 2);
        dfs(x + n / 2, y + n / 2, n / 2);
    }
}
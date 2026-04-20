import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, K;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        for(int i = 0; i < N; i++) {
            Arrays.fill(map[i], 100000000);
            map[i][i] = 0;
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());

            map[from][to] = Math.min(map[from][to], cost);
        }

        boolean flag = true;
        while(flag){
            flag = false;

            for(int i = 0; i < N; i++){

                for(int from = 0; from < N; from++){
                    for(int to = 0; to < N; to++){
                        
                        if(map[from][to] > map[from][i] + map[i][to]){
                            map[from][to] = map[from][i] + map[i][to];
                            flag = true;
                        }
                    }
                }
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                sb.append(map[i][j] == 100000000 ? 0 : map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, K;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            map[a][b] = 1;
            map[b][a] = 1;
        }

        boolean flag = true;
        while(flag){
            flag = false;

            for(int i = 0; i < N; i++){
                
                for(int j = 0; j < N; j++){
                    if(i == j) continue;

                    for(int k = 0; k < N; k++){
                        if(i == k || j == k) continue;

                        if(map[i][k] != 0 && map[k][j] != 0){
                            if(map[i][j] == 0 || map[i][j] > map[i][k] + map[k][j]){
                                map[i][j] = map[i][k] + map[k][j];
                                flag = true;
                            }
                        }
                    }
                    
                }
            }
        }

        int kevin = Integer.MAX_VALUE;
        int kevinNum = 0;

        for(int i = 0; i < N; i++){
            int sum = 0;

            for(int j = 0; j < N; j++){
                sum += map[i][j];
            }

            if(kevin > sum){
                kevin = sum;
                kevinNum = i;
            }
        }

        System.out.println(kevinNum + 1);
    }
}
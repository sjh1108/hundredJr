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

        int[][] map1 = new int[N][M];
        int[][] map2 = new int[N][M];
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                map1[i][j] = str.charAt(j) - '0';
            }
        }
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                map2[i][j] = str.charAt(j) - '0';
            }
        }

        int ans = 0;
        for(int i = 0; i < N - 2; i++) {
            for(int j = 0; j < M - 2; j++) {
                if(map1[i][j] != map2[i][j]) {
                    ans++;
                    for(int k = i; k < i + 3; k++) {
                        for(int l = j; l < j + 3; l++) {
                            map1[k][l] = map1[k][l] == 0 ? 1 : 0;
                        }
                    }
                }
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++) {
                if(map1[i][j] != map2[i][j]) {
                    System.out.println(-1);
                    return;
                }
            }
        }


        System.out.println(ans);
    }
}
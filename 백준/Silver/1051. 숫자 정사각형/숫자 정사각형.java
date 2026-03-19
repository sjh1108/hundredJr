import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, K;

    //https://www.acmicpc.net/problem/1051
    static int box[][];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        box = new int[N][M];

        int maxSize = (int)(Math.min(N, M));
        for(int i = 0; i < N; i++){
            String s = br.readLine();
            for(int j = 0; j < M; j++){
                box[i][j] = (int)(s.charAt(j) - '0');
            }
        }

        int p = 0;
        while(true) {
            for(int i = 0; i < N - maxSize; i++){
                for(int j = 0; j < M - maxSize; j++){
                    p = box[i][j];
                    if(box[i + maxSize][j] == p){
                        if(box[i][j + maxSize] == p){
                            if(box[i + maxSize][j + maxSize] == p){
                                maxSize++;
                                System.out.println(maxSize * maxSize);
                                return;
                            }
                        }
                    }
                }
            }

            maxSize--;
        }
    }

}
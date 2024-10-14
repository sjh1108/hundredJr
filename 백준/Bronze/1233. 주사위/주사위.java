import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M, K;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + M + K + 1];

        int max = 0;
        int maxIndex = 0;
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                for(int k = 1; k <= K; k++){
                    arr[i + j + k]++;
                    if(arr[i + j + k] > max){
                        max = arr[i + j + k];
                        maxIndex = i + j + k;
                    }
                }
            }
        }
        System.out.println(maxIndex);
    }
}
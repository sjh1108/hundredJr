import java.util.*;
import java.io.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N, M;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int arr[] = new int[N + 1];
        int cost[] = new int[N + 1];
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= i; j++){
                cost[i] = Math.max(cost[i], cost[i - j] + arr[j]);
            }
        }

        System.out.println(cost[N]);
    }
}
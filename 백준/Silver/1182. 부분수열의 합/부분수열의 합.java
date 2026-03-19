import java.util.*;
import java.io.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int cnt = 0;
    static int N;
    static int S;
    static int arr[];

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        DFS(0, 0);
        if(S == 0) cnt--;
        System.out.println(cnt);
    }

    static void DFS(int depth, int sum){
        if(depth == N){
            if(sum == S) cnt++;
            return;
        }
        
        DFS(depth + 1, sum + arr[depth]);
        DFS(depth + 1, sum);
    }
}
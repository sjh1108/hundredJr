import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    static int[] arr;
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        tmp = new int[M];

        dfs(0, 0);

        System.out.println(sb);
    }

    static int[] tmp;
    static void dfs(int cnt, int start){
        if(cnt == M){
            for(int i = 0; i < M; i++){
                sb.append(tmp[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i < N; i++){
            tmp[cnt] = arr[i];
            dfs(cnt + 1, i + 1);
        }
    }
}
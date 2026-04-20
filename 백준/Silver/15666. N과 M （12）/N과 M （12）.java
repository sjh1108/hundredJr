import java.util.*;
import java.io.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N, M;
    static int[] arr, ans;
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        ans = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        DFS(0, 0);
        
        System.out.println(sb);
    }

    static void DFS(int cnt, int value){
        if(cnt == M){
            for(int val : ans){
                sb.append(val).append(" ");
            }
            sb.append('\n');
        } else{
            int before = 0;

            for(int i = value; i < N; i++){
                if(before != arr[i]){
                    ans[cnt] = arr[i];
                    before = arr[i];
                    DFS(cnt+1, i);
                }
            }
        }
    }
}
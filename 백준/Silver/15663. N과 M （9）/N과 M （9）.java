import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] arr, ans;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N]; ans = new int[M];
        visited = new boolean[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        DFS(0);

        System.out.println(sb);
    }

    static void DFS(int cnt){
        if(cnt == M){
            for(int val : ans) sb.append(val).append(" ");
            sb.append("\n");
            return;
        }
        
        int before = 0;
        for(int i = 0; i < N; i++){
            if(visited[i]) continue;

            if(before != arr[i]){
                visited[i] = true;
                ans[cnt] = arr[i];
                before = arr[i];
                DFS(cnt + 1);
                visited[i] = false;
            }
        }
    }
}

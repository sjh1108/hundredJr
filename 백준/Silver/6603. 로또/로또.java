import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        while(N != 0){
            arr = new int[N];
            visited = new boolean[N];

            for(int i = 0; i < N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);

            sb.append('\n');

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
        }

        System.out.println(sb);
    }

    static void dfs(int depth, int start){
        if(depth == 6){
            for(int i = 0; i < N; i++){
                if(visited[i]){
                    sb.append(arr[i]).append(' ');
                }
            }
            sb.append('\n');
            return;
        }

        for(int i = start; i < N; i++){
            visited[i] = true;
            dfs(depth+1, i+1);
            visited[i] = false;
        }
    }
}
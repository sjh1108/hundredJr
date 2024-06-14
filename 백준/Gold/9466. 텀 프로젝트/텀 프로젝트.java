import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    static int[] student_arr;
    static boolean[] visited;
    static boolean[] isTeam;

    public static void main(String[] args) throws IOException{
        int test_case = Integer.parseInt(br.readLine());

        while(test_case-- > 0){
            N = Integer.parseInt(br.readLine());

            M = 0;
            student_arr = new int[N+1];
            visited = new boolean[N+1];
            isTeam = new boolean[N+1];

            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; i++){
                student_arr[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 1; i <= N; i++){
                DFS(i);
            }
            sb.append(N - M).append('\n');
        }

        System.out.println(sb);
    }

    static void DFS(int cur){
        if(visited[cur]) return;

        visited[cur] = true;
        int nxt = student_arr[cur];

        if(!visited[nxt]){
            DFS(nxt);
        } else{
            if(!isTeam[nxt]){
                for(int i = nxt; i != cur; i = student_arr[i]){
                    M++;
                }
                M++;
            }
        }

        isTeam[cur] = true;
    }
}
import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, K;
    static int[] arr;

    static int[][] node;
    static boolean[] visit;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        node = new int[N + 1][N + 1];
        visit = new boolean[N + 1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int startNode = Integer.parseInt(st.nextToken());
            int endNode = Integer.parseInt(st.nextToken());

            node[startNode][endNode] = 1;
            node[endNode][startNode] = 1;
        }

        dfs(start);
        sb.append('\n');
        visit = new boolean[N + 1];
        bfs(start);

        System.out.println(sb);
    }

    static void dfs(int start){
        visit[start] = true;
        sb.append(start).append(' ');

        for(int i = 0; i <= N; i++){
            if(node[start][i] == 1 && !visit[i]){
                dfs(i);
            }
        }
    }
    static void bfs(int start){
        q.add(start);
        visit[start] = true;

        while(!q.isEmpty()){
            start = q.poll();
            sb.append(start).append(' ');

            for(int i = 1; i <= N; i++){
                if(node[start][i] == 1 && !visit[i]){
                    q.add(i);
                    visit[i] = true;
                }
            }
        }
    }
}
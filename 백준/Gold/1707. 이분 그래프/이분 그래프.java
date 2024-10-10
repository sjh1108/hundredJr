import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M, K;
    static int[] colors;
    static List<List<Integer>> graph;

    static boolean bfs(int start, int color){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        colors[start] = color;
        while(!q.isEmpty()){
            int cur = q.poll();

            for(int next : graph.get(cur)){
                if(colors[next] == colors[cur]){
                    return false;
                }

                if(colors[next] == 0){
                    colors[next] = -colors[cur];
                    q.add(next);
                }
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            for(int i = 0; i <= N; i++){
                graph.add(new ArrayList<>());
            }

            while(M-- > 0){
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            boolean flag = true;
            colors = new int[N + 1];
            for(int i = 1; i <= N; i++){
                if(colors[i] == 0){
                    flag = bfs(i, 1);
                }
                if(!flag) break;
            }

            if(flag){
                sb.append("YES\n");
            }else{
                sb.append("NO\n");
            }
        }

        System.out.println(sb);
    }
}
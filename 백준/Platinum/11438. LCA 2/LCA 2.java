import java.io.*;
import java.util.*;

class Main {
    private static int K_MAX;
    
    private static int[] depths;
    private static int[][] parents;
    private static List<List<Integer>> list;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        K_MAX = (int) Math.floor(Math.log(N) / Math.log(2));

        depths = new int[N+1];
        parents = new int[N+1][K_MAX+1];
        
        list = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            list.add(new ArrayList<>());
        }

        StringTokenizer st;
        for(int i = 0; i < N-1; i++){
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            list.get(a).add(b);
            list.get(b).add(a);
        }
        
        initTree(1, 1, 0);
        setParent(N);
        
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int parent = LCA(a, b);
            sb.append(parent + "\n");
        }

        System.out.println(sb);
    }

    private static void initTree(int cur, int depth, int parent){
        depths[cur] = depth;
        parents[cur][0] = parent;

        for(int nxt: list.get(cur)){
            if(nxt != parent){
                initTree(nxt, depth+1, cur);
            }
        }
    }

    private static void setParent(int N){
        for(int k = 1; k <= K_MAX; k++){
            for(int i = 1; i <= N; i++){
                parents[i][k] = parents[parents[i][k-1]][k-1];
            }
        }
    }

    private static int LCA(int a, int b){
        if(depths[a] < depths[b]){
            int tmp = a;
            a = b;
            b = tmp;
        }

        for(int k = K_MAX; k >= 0; k--){
            if(depths[a] - (1<<k) >= depths[b]){
                a = parents[a][k];
            }
        }

        if(a == b) return a;

        for(int k = K_MAX; k >= 0; k--){
            if(parents[a][k] != parents[b][k]){
                a = parents[a][k];
                b = parents[b][k];
            }
        }

        return parents[a][0];
    }
}
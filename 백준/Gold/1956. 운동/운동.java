import java.util.*;
import java.io.*;

public class Main{
    private static final int INF = 1 << 25;

    private static int V, E;
    private static int[][] dist;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken()); E = Integer.parseInt(st.nextToken());

        dist = new int[V][V];
        for(int[] d: dist){
            Arrays.fill(d, INF);
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());

            dist[from][to] = cost;
        }

        for(int k = 0; k < V; k++){
            for(int i = 0; i < V; i++){
                for(int j = 0; j < V; j++){
                    if(i == j) continue;

                    if(dist[i][j] > dist[i][k] + dist[k][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }

        int ans = INF;

        for(int i = 0; i < V; i++){
            for(int j = 0; j < V; j++){
                if(i == j) continue;

                if(dist[i][j] != INF && dist[j][i] != INF){
                    ans = Math.min(ans, dist[i][j] + dist[j][i]);
                }
            }
        }

        System.out.println((ans == INF) ? -1 : ans);
    }
}
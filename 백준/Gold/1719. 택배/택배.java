import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int INF = 10_000_000;
    
        int[][] dist = new int[N+1][N+1];
        int[][] map = new int[N+1][N+1];
        for(int i = 1; i <= N; i++){
            Arrays.fill(dist[i], INF);
            Arrays.fill(map[i], INF);
            map[i][i] = dist[i][i] = 0;
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            dist[f][t] = dist[t][f] = c;
            map[f][t] = t;
            map[t][f] = f;
        }

        for(int k = 1; k <= N; k++){
            for(int i = 1; i <= N; i++){
                if(i == k) continue;
                for(int j = 1; j <= N; j++){
                    if(j == k || j == i) continue;

                    if(dist[i][k] == INF || dist[k][j] == INF) continue;
                    if(dist[i][j] <= dist[i][k] + dist[k][j]) continue;

                    dist[i][j] = dist[i][k] + dist[k][j];
                    map[i][j] = map[i][k];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(i == j) sb.append('-');
                else sb.append(map[i][j]);
                sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static int N, L;

    private static int max;

    private static int[][] food;

    private static void dfs(int start, boolean[] visited){
        visited[start] = true;

        int sumTastes = 0;
        int sumCalories = 0;
        for(int i = 0; i < N; i++){
            if(visited[i]){
                sumTastes += food[i][0];
                sumCalories += food[i][1];
            }
        }

        if(L < sumCalories) return;
        max = Math.max(sumTastes, max);

        for(int i = start+1; i < N; i++){
            dfs(i, visited);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t = 1; t <= T; t++){
            sb.append("#" + t).append(' ');

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            food = new int[N][2];
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                food[i][0] = Integer.parseInt(st.nextToken());
                food[i][1] = Integer.parseInt(st.nextToken());
            }

            max = 0;
            for(int i = 0; i < N; i++){
                dfs(i, new boolean[N]);
            }

            sb.append(max);
            sb.append('\n');
        }

        System.out.println(sb);
    }

}

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t = 1; t <= T; t++){

            int N = Integer.parseInt(br.readLine());

            int[] ans = new int[N];
            int[] price = new int[N*2];
            boolean[] visited = new boolean[N*2];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N*2; i++)
                price[i] = Integer.parseInt(st.nextToken());

            int cnt = 0;


            for(int i = 0; i < N*2; i++){
                if(cnt == N) break;

                if(visited[i] || price[i] % 3 != 0) continue;

                visited[i] = true;
                long p = price[i] / 3 * 4;

                for(int j = i + 1; j < N*2; j++){
                    if(visited[j]) continue;

                    if(price[j] == p){
                        ans[cnt++] = price[i];
                        visited[j] = true;
                        break;
                    }
                }
            }

            sb.append("Case #").append(t).append(": ");
            for(int a: ans){
                sb.append(a).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
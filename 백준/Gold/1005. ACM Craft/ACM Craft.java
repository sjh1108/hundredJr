import java.io.*;
import java.util.*;

class Main {
    private static int N, K;

    private static int[] delay, dp;
    private static List<List<Integer>> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dp = new int[1001];
        delay = new int[1001];
        list = new ArrayList<>();
        for(int i = 0; i < 1001; i++){
            list.add(new ArrayList<>());
        }
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(T-- > 0){
            for(List<Integer> l: list){
                l.clear();
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; ++i) {
                delay[i] = Integer.parseInt(st.nextToken());
                dp[i] = Integer.MAX_VALUE;
            }

            while(K-- > 0){
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                list.get(y).add(x);
            }

            sb.append(dfs(Integer.parseInt(br.readLine())));
            sb.append('\n');
        }

        System.out.print(sb);
    }

    private static int dfs(int start){
        int max = 0;
        if(dp[start] != Integer.MAX_VALUE) return dp[start];

        for(int x : list.get(start)){
            max = Math.max(max, dfs(x));
        }

        dp[start] = max + delay[start];

        return dp[start];
    }
}
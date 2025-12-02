import java.io.*;
import java.util.*;

class Main {
    private static final long INF = 1L << 60;

    static class Switch {
        int weight;
        long cost;

        public Switch(int weight, long cost) {
            this.weight = weight;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        List<Switch> list = new ArrayList<>();
        
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            
            list.add(new Switch(a - 2, b));
        }

        int M = Integer.parseInt(br.readLine());

        int target = M - 1;

        if (target == 0) {
            System.out.println(0);
            return;
        }

        long[] dp = new long[target + 1];
        Arrays.fill(dp, INF);

        dp[0] = 0;

        for (Switch s : list) {
            for (int j = target; j >= s.weight; j--) {
                if (dp[j - s.weight] != INF) {
                    dp[j] = Math.min(dp[j], dp[j - s.weight] + s.cost);
                }
            }
        }

        System.out.println(dp[target] == INF ? -1 : dp[target]);
    }
}
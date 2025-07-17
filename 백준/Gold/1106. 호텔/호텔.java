import java.util.*;
import java.io.*;

public class Main{
    private static int N, C;

    static class Node implements Comparable<Node> {
        int cost;
        int value;

        Node(int cost, int value) {
            this.cost = cost;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int maxAds = 0;
        Node[] nodes = new Node[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(cost, value);

            maxAds = Math.max(maxAds, value);
        }

        int[] dp = new int[C + maxAds + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0; i < C; i++){
            if(dp[i] == Integer.MAX_VALUE) continue;

            for (Node node : nodes) {
                int afterAds = i + node.value;

                dp[afterAds] = Math.min(dp[afterAds], dp[i] + node.cost);
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = C; i < dp.length; i++) {
            if (dp[i] != Integer.MAX_VALUE) {
                result = Math.min(result, dp[i]);
            }
        }

        System.out.println(result);
    }
}
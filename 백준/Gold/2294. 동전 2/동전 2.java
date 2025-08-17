import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] dp = new int[100001];
        Arrays.fill(dp, Integer.MAX_VALUE);
        Queue<Integer> q = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();

        while(N-- > 0){
            int tmp = Integer.parseInt(br.readLine());
            q.offer(tmp);
            dp[tmp] = 1;
            set.add(tmp);
        }

        Integer[] list = set.toArray(new Integer[set.size()]);

        while(!q.isEmpty()){
            int cur = q.poll();

            for(Integer i: list){
                int tmp = cur + i;

                if(tmp > K) continue;
                if(dp[tmp] > dp[cur] + 1){
                    q.offer(tmp);
                    dp[tmp] = dp[cur]+1;
                }
            }
        }

        if(dp[K] == Integer.MAX_VALUE) System.out.println(-1);
        else{
            System.out.println(dp[K]);
        }
    }
}
import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    static int[] bridge;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        bridge = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            bridge[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()); int end = Integer.parseInt(st.nextToken());

        System.out.println(bfs(start, end));
    }

    static int bfs(int start, int end){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, 0});

        boolean visited[] = new boolean[N + 1];
        visited[start] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            visited[cur[0]] = true;

            if(cur[0] == end){
                return cur[1];
            }
            
            int tmp = cur[0];
            while(true){
                tmp += bridge[cur[0]];
                if(tmp > N) break;
                if(visited[tmp]) continue;
                visited[tmp] = true;

                if(tmp == end) return cur[1] + 1;
                if(tmp <= N) q.add(new int[]{tmp, cur[1] + 1});
            }

            tmp = cur[0];
            while (true) {
                tmp -= bridge[cur[0]];
                if (tmp < 1) break;
                if (visited[tmp]) continue;
                visited[tmp] = true;

                if (tmp == end) return cur[1] + 1;
                if (tmp >= 1) q.add(new int[] { tmp, cur[1] + 1 });
            }
        }

        return -1;
    }
}
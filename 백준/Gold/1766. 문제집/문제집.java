import java.io.*;
import java.util.*;

public class Main{
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N, M, K;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] indegree = new int[N + 1];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int before = Integer.parseInt(st.nextToken());
            int after = Integer.parseInt(st.nextToken());

            graph.get(before).add(after);
            indegree[after]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 1; i <= N; i++){
            if(indegree[i] == 0){
                pq.add(i);
            }
        }

        while(!pq.isEmpty()){
            int now = pq.poll();
            sb.append(now).append(" ");

            for(int i : graph.get(now)){
                indegree[i]--;

                if(indegree[i] == 0){
                    pq.add(i);
                }
            }
        }

        System.out.println(sb);

    }
}
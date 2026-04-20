import java.util.*;
import java.io.*;

public class Main{
    static class Node implements Comparable<Node>{
        int idx;
        int cost;

        public Node(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(o.cost, this.cost);
        }
    }

    private static List<Node> list;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long N = n * 2;

        list = new ArrayList<>();

        int M = Integer.parseInt(st.nextToken());
        for(int i = 0; i < M;){
            st = new StringTokenizer(br.readLine());
            list.add(new Node(++i, Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list);

        long sum = 0L;
        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < M; i++){
            int cur = list.get(i).cost;

            if(sum + cur >= n && sum + cur <= N){
                ans.add(list.get(i).idx);
                break;
            }

            if(sum + cur <= N){
                sum += cur;
                ans.add(list.get(i).idx);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(ans.size() + "\n");
        for(int idx: ans){
            sb.append(idx + "\n");
        }

        System.out.println(sb);
    }
}
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new int[]{v, w});
        }

        List<List<Integer>> dist = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            dist.add(new ArrayList<>());
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        
        pq.add(new int[]{0, 0});
        dist.get(0).add(0);

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0];
            int cost = cur[1];

            for (int[] next : graph.get(u)) {
                int v = next[0];
                int w = next[1];
                int newCost = cost + w;
                
                List<Integer> vDist = dist.get(v);

                if (vDist.size() < k) {
                    vDist.add(newCost);
                    Collections.sort(vDist);
                    pq.add(new int[]{v, newCost});
                } 
                else {
                    int maxDist = vDist.get(vDist.size() - 1);
                    
                    if (newCost < maxDist) {
                        vDist.remove(vDist.size() - 1);
                        vDist.add(newCost);
                        Collections.sort(vDist);
                        pq.add(new int[]{v, newCost});
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(List<Integer> d : dist) {
            if (d.size() == k)  sb.append(d.get(k - 1)).append('\n');
            else                sb.append(-1).append('\n');
        }
        System.out.println(sb);
    }
}
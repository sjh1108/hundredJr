import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<List<int[]>> edge = new ArrayList<>();
        List<List<Integer>> dist = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            edge.add(new ArrayList<>());
            dist.add(new ArrayList<>());
        }
        
        while(M -- > 0){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            edge.get(a).add(new int[]{b, d});
        }

        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.add(new int[]{1, 0});
        dist.get(1).add(0);

        while(!pq.isEmpty()){
            int[] cur = pq.poll();

            int u = cur[0];
            int v = cur[1];

            for(int[] next: edge.get(u)){
                int nu = next[0];
                int nv = v + next[1];

                List<Integer> nDist = dist.get(nu);

                if(nDist.size() < K){
                    nDist.add(nv);
                    Collections.sort(nDist);
                    pq.add(new int[]{nu, nv});
                } else{
                    int max = nDist.get(nDist.size() - 1);

                    if(nv < max){
                        nDist.remove(nDist.size() - 1);
                        nDist.add(nv);
                        Collections.sort(nDist);
                        pq.add(new int[]{nu, nv});
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++){
            if(dist.get(i).size() < K){
                sb.append(-1);
            } else{
                sb.append(dist.get(i).get(K-1));
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
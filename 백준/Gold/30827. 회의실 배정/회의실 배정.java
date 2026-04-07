import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[][] meets = new int[N][2];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            meets[i][0] = Integer.parseInt(st.nextToken());
            meets[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(meets, Comparator.comparingInt(o -> o[1]));

        int ans = 0;

        TreeMap<Integer, Integer> rooms = new TreeMap<>();
        int roomCount = 0;

        for(int[] meet: meets){
            int s = meet[0];
            int e = meet[1];

            Map.Entry<Integer, Integer> best = rooms.lowerEntry(s);
            if(best != null){
                if(best.getValue() == 1) rooms.remove(best.getKey());
                else rooms.merge(best.getKey(), -1, Integer::sum);
                rooms.merge(e, 1, Integer::sum);
                ++ans;
            } else if(roomCount < K){
                rooms.merge(e, 1, Integer::sum);
                ++roomCount;
                ++ans;
            }
        }   

        System.out.println(ans);
    }
}
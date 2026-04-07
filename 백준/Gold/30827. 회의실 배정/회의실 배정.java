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

        List<Integer> rooms = new ArrayList<>();
        outLoop: for(int[] meet: meets){
            int s = meet[0];
            int e = meet[1];

            Collections.sort(rooms, Comparator.reverseOrder());

            for(int i = 0; i < rooms.size(); i++){
                if(rooms.get(i) < s){
                    rooms.remove(i);
                    rooms.add(e);
                    ++ans;
                    continue outLoop;
                }
            }
            if(rooms.size() < K){
                ++ans;
                rooms.add(e);
            }
        }   

        System.out.println(ans);
    }
}
import java.io.*;
import java.util.*;

class Main {
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[][] line = new int[N][3];
        for(int i = 0; i < N; i++){
            line[i][0] = i;

            st = new StringTokenizer(br.readLine());

            line[i][1] = Integer.parseInt(st.nextToken());
            line[i][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(line, Comparator.comparingInt(o -> o[1]));

        int[] LIS = new int[N];
        int[] tracking = new int[N];

        int len = 0;
        for(int i = 0; i < N; i++){
            int b = line[i][2];

            int idx = Arrays.binarySearch(LIS, 0, len, b);
            if(idx < 0) idx = -idx - 1;
            
            LIS[idx] = b;
            tracking[i] = idx;

            if(idx == len) len++;
        }

        System.out.println(N - len);

        boolean[] isLIS = new boolean[N];

        int curLISIdx = len - 1;
        for(int i = N-1; i >= 0; i--){
            if(tracking[i] == curLISIdx){
                isLIS[i] = true;
                curLISIdx--;
            }

            if(curLISIdx < 0) break;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++){
            if(!isLIS[i]){
                pq.add(line[i][1]);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            sb.append(pq.poll() + "\n");
        }
        System.out.print(sb);
    }
}
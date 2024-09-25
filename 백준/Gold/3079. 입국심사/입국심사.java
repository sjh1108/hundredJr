import java.io.*;
import java.util.*;

public class Main{
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N, M, K;

    static long[] times;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        times = new long[N];
        for(int i = 0; i < N; i++){
            times[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(times);
        
        long result = Long.MAX_VALUE;
        long low = 0;
        long high = times[N-1]*M;

        while(low <= high){
            long mid = (low+high)/2;

            long time = 0;
            for(long t: times){
                time += mid/t;
                if(time >= M) break;
            }

            if(time < M){
                low = mid+1;
            } else{
                high = mid-1;
                result = Math.min(result, mid);
            }
        }

        System.out.println(result);
    }
}
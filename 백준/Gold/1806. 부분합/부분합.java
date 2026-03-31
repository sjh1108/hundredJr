import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int INF = 1_000_000_000;

        int[] sum = new int[N + 1];
        
        int point = 0;
        int min = INF;

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            int input = Integer.parseInt(st.nextToken());

            sum[i] = sum[i-1] + input;

            while(sum[i] - sum[point] >= S){
                min = Math.min(min, i - point);
                point++;
            }
        }

        System.out.println(min == INF ? 0 : min);
    }
}
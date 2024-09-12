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

        int[] arr = new int[N+1];
        long ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            int input = Integer.parseInt(st.nextToken());
            arr[i] = arr[i-1] + input;

            if(arr[i] == M) ans++;
            if(map.containsKey(arr[i] - M)) ans += map.get(arr[i] - M);
            if(!map.containsKey(arr[i])) map.put(arr[i], 1);
            else
                map.put(arr[i], map.get(arr[i]) + 1);
        }

        System.out.println(ans);
    }
}
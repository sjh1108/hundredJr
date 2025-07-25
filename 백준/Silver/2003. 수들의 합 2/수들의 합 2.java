import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] sum = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            sum[i] = Integer.parseInt(st.nextToken()) + sum[i-1];
        }

        int cnt = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j < i; j++){
                if(sum[i] - sum[j] == m) cnt++;
            }

            if(sum[i] == m) cnt++;
        }

        System.out.println(cnt);
    }
}
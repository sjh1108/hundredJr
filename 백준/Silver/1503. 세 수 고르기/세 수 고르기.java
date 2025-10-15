import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] arr = new boolean[1002];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            arr[Integer.parseInt(st.nextToken())] = true;
        }

        int min = 1_000_000_000;
        for(int i = 1; i < 52; i++){
            if(arr[i]) continue;
            for(int j = i; j < 52; j++){
                if(arr[j]) continue;
                for(int k = j; k <= 1001; k++){
                    if(arr[k]) continue;

                    min = Math.min(min, Math.abs(N - (i*j*k)));
                }
            }
        }
        System.out.println(min);
    }
}
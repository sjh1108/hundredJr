import java.io.*;
import java.util.*;

class Main {
    private static final int MOD = 1_000_000_007;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long ans = 0;

        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        for(int i = 0; i < N; i++){
            ans += arr[i] * ((pow(2, i) - 1) - (pow(2, (N-1) - i) - 1)) % MOD;
            ans %= MOD; 
        }

        System.out.println((ans + MOD) % MOD);
    }

    private static long pow(long num, int p){
        if(p == 0) return 1;

        long tmp = pow(num, p/2);
        if(p % 2 == 1) return ((tmp * tmp) % MOD) * num % MOD;
        else return tmp * tmp % MOD;
    }
}
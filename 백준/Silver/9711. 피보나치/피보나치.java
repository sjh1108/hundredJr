import java.io.*;
import java.math.BigInteger;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        int[] ps =  new int[T+1];
        BigInteger[] qs = new BigInteger[T+1];
        
        StringTokenizer st;
        int max = 0;
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            ps[t] = Integer.parseInt(st.nextToken());
            qs[t] = new BigInteger(st.nextToken());
            max = Math.max(max,ps[t]);
        }

        BigInteger[] fib = new BigInteger[10001];
        fib[1] = new BigInteger("1");
        fib[2] = new BigInteger("1");
        for (int i = 3; i <= max; i++) {
            fib[i] = fib[i-1].add(fib[i-2]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= T; i++) {
            sb.append("Case #" + i + ": " + fib[ps[i]].remainder(qs[i]) + "\n");
        }
        System.out.print(sb);
    }
}
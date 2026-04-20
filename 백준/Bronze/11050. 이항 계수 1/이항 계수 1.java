import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] pas;
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        sb.append(pascal(n, m));

        System.out.println(sb);
    }

    static int pascal(int n, int m){
        int tmp = 0;

        if (m == 0 || m == n){
            return 1;
        }
        int[] fac = new int[11];
        fac[0] = 1; fac[1] = 1;
        for(int i = 1; i < 11; i++){
            fac[i] = fac[i - 1] * i;
        }
        int up = fac[n];
        int mo = fac[m] * fac[n - m];
        tmp = up / mo;
        
        return tmp;
    }

    static int gcd(int p, int q){
        if(q == 0) return p;
        return gcd(q, p % q);
    }
}
import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        int x = Integer.parseInt(br.readLine());
        for(int i = 0; i < x; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int factor = 1;
            int multiple = 1;

            factor = gcd(n, m);
            int a = n / factor;
            int b = m / factor;
            int c = 0;
            if(a % b == 0 || a == b){
                multiple = factor * a;
            } else if(b % a == 0){
                multiple = factor * b;
            } else{
                c = gcd(a, b);
                a /= c;
                b /= c;
                multiple = factor * a * b;
            }

            sb.append(multiple).append('\n');
        }

        System.out.println(sb);
    }
    static int gcd(int p, int q){
        if(q == 0) return p;
        return gcd(q, p % q);
    }
}
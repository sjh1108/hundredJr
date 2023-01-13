import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());

        int[] ring = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int tmp = 0;
        ring[0] = Integer.parseInt(st.nextToken());
        for(int i = 1; i < n; i++){
            ring[i] = Integer.parseInt(st.nextToken());

            if(ring[0] == ring[i]){
                sb.append("1/1");
            } else if(ring[0] % ring[i] == 0){
                tmp = ring[0] / ring[i];
                sb.append(tmp).append('/').append(1);
            } else if(ring[i] % ring[0] == 0){
                tmp = ring[i] / ring[0];
                sb.append(1).append('/').append(tmp);
            } else{
                int gcdVal = gcd(ring[0], ring[i]);
                tmp = ring[0] / gcdVal;
                sb.append(tmp).append('/');
                tmp = ring[i] / gcdVal;
                sb.append(tmp);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
    static int gcd(int p, int q){
        if(q == 0) return p;
        return gcd(q, p % q);
    }
}
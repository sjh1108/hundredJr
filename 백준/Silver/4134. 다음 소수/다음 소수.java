import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, K;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            long a = Long.parseLong(br.readLine());
            BigInteger bi = new BigInteger(String.valueOf(a));

            if(bi.isProbablePrime(10)){
                sb.append(bi);
            } else{
                sb.append(bi.nextProbablePrime());
            }

            sb.append('\n');
        }

        System.out.println(sb);
    }

}
import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;


    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        BigInteger arr[] = new BigInteger[N + 2];

        arr[0] = arr[1] = arr[2]= BigInteger.valueOf(1);

        for(int i = 3; i <= N; i++){
            arr[i] = arr[i - 1].add(arr[i - 2]);
        }

        System.out.println(arr[N]);
    }

}
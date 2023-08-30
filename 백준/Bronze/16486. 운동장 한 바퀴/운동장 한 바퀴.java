import java.util.*;
import java.io.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine()) * 2;

        double sum = 0d;

        sum += (N) * 2;
        sum += M * Math.PI;

        System.out.println(sum);
    }

}
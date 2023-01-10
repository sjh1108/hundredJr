//import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();

        final int M = 1234567891;
        long sum = 0;

        for(int i = 0; i < N; i++){
            int a = s.charAt(i) - 'a' + 1;
            int b = (int) Math.pow(31, i);

            sum += a * b;
        }
        sum %= M;

        System.out.println(sum);
    }
}
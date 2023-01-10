//import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();

        long sum = 0;
        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = s.charAt(i) - 'a' + 1;
            sum += arr[i] * Math.pow(31, i);
        }

        sb.append(sum);

        System.out.println(sb);
    }
}
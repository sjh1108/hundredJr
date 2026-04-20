import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, K;

    public static void main(String[] args) throws IOException {
        int sum = 0;
        
        int tmp = 0;
        int gap = 100;
        while(tmp++ < 10){
            int n = Integer.parseInt(br.readLine());
            sum += n;
            
            if(Math.abs(100 - sum) <= gap){
                gap = Math.abs(100 - sum);
            }

            if(sum > 100){
                if(gap == Math.abs(100 - sum)){
                    break;
                }
                sum -= n;
                break;
            }
        }

        System.out.println(sum);
    }
}
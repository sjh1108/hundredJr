import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M, K;
    
    public static void main(String[] args) throws IOException{
        int time = Integer.parseInt(br.readLine());
        br.readLine();

        st = new StringTokenizer(br.readLine());
        int sum = 0;
        while(st.hasMoreTokens()){
            sum += Integer.parseInt(st.nextToken());
        }
        if(time > sum){
            System.out.println("Padaeng_i Cry");
        } else{
            System.out.println("Padaeng_i Happy");
        }
    }
}
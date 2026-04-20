import java.io.*;
import java.util.*;

public class Main{
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N, M, K;

    static int[] arr;
    static void get(){
        arr = new int[80001];
        int sum = 0;
        for(int i = 3; i <= 80000; i++){
            if(i % 3 == 0 && i % 7 == 0){
                sum += i;
            } else if(i % 3 == 0){
                sum += i;
            } else if(i % 7 == 0){
                sum += i;
            }
            arr[i] = sum;
        }
    }
    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        get();
        while(N-- > 0){
            M = Integer.parseInt(st.nextToken());
            sb.append(arr[M]).append("\n");
        }
        System.out.println(sb);
    }
}
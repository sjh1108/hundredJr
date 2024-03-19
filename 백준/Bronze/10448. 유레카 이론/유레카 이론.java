import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    static int[] arr;
    static boolean[] check = new boolean[1001];

    public static void main(String[] args) throws IOException{
        arr = new int[45];
        for(int i = 1; i < 45; i++){
            arr[i] = i*(i+1)/2;
        }

        for(int i = 1; i < 1001; i++) search(0, i, i);
        
        N = Integer.parseInt(br.readLine());
        while(N-- > 0){
            int tmp = Integer.parseInt(br.readLine());
            
            if(check[tmp]) sb.append(1).append("\n");
            else sb.append(0).append("\n");
        }

        System.out.println(sb);
    }

    static void search(int cnt, int cur, int idx){
        if(cnt == 3){
            if(cur == 0) check[idx] = true;
            return;
        }
        if(cur <= 0) return;

        for(int i = 1; i < 45; i++){
            if(cur < arr[i]) break;
            search(cnt+1, cur-arr[i], idx);
        }
    }
}
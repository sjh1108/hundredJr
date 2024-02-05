import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            M = Integer.parseInt(br.readLine());

            arr = new int[M + 1];
            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[a] = b;
            }

            int max = arr[1];
            int cnt = 1;
            for(int i = 2; i <= M; i++){
                if(arr[i] < max){
                    cnt++;
                    max = arr[i];
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}
import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int M;
    static int K;

    static int[] arr;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        arr = new int[11];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;

        int tmp = 3;
        while(N-- > 0){
            M = Integer.parseInt(br.readLine());

            if(tmp > M){
                sb.append(arr[M]);
            } else{
                for(int i = tmp + 1; i <= M; i++){
                    arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
                }
                
                sb.append(arr[M]);
            }

            sb.append('\n');
        }

        System.out.println(sb);
    }
}
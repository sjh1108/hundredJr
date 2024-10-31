import java.io.*;
import java.util.*;

public class Main{
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N, M, K;
    
    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        int[] sum = new int[N];
        int[][] arr = new int[N][3];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < 3; j++){
                boolean flag = true;

                for(int k = 0; k < N; k++){
                    if(i == k) continue;

                    if(arr[i][j] == arr[k][j]){
                        flag = false;
                        break;
                    }
                }

                if(flag){
                    sum[i] += arr[i][j];
                }
            }
        }
        for(int i: sum){
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}
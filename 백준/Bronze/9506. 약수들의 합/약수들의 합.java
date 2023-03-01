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

        while(N != -1){
            boolean isPerfect = true;

            arr = new int[N];
            int tmp = 0;
            int sum = 0;
            for(int i = 1; i <= Math.max(Math.sqrt(N), N / 2); i++){
                if(N % i == 0){
                    arr[tmp++] = i;
                    sum += i;

                    if(sum > N){
                        break;
                    }
                }
            }

            if(sum != N){
                isPerfect = false;
            }
            
            sb.append(N);
            if(isPerfect){
                sb.append(" = ");
                for(int i = 0; i < tmp; i++){
                    sb.append(arr[i]);

                    if(i < tmp - 1){
                        sb.append(" + ");
                    }
                }
            }
            else{
                sb.append(" is NOT perfect.");
            }

            sb.append('\n');

            N = Integer.parseInt(br.readLine());
        }

        System.out.println(sb);
    }

}
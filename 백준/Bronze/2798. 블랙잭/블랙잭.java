import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int max = 0;
        int sum = 0;
        for(int i = N - 1; i >= 0; i--){
            sum = arr[i];
            for(int j = i - 1; j >= 0; j--){
                sum += arr[j];
                for(int k = j - 1; k >= 0; k--){
                    sum += arr[k];
                    if(sum > max && sum <= M){
                        max = sum;
                    }
                    sum -= arr[k];
                }
                sum -= arr[j];
            }
            sum -= arr[i];
        }
        sb.append(max);

        System.out.println(sb);
    }
}
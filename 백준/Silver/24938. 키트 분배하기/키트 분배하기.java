import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long sum = 0;
        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int value = Integer.parseInt(st.nextToken());

            sum += value;
            arr[i] = value;
        }

        long res = 0;
        sum /= N;
        for(int i = 0; i < N; i++){
            long n = 0;

            if(arr[i] < sum){
                n = sum - arr[i];
                arr[i+1] = arr[i+1] - n;
                arr[i] += n;
            } else if(arr[i] > sum){
                n = arr[i] - sum;
                arr[i] = arr[i] - n;
                arr[i+1] = arr[i+1] + n;
            }

            res += n;
        }

        System.out.println(res);
    }
}
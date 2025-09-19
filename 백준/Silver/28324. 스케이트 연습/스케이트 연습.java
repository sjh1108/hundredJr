import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long sum = 0;
        for(int i = N-1; i >= 0; i--){
            int speed = Math.min(arr[i+1] + 1, arr[i]);
            sum += speed;
            arr[i] = speed;
        }

        System.out.println(sum);
    }
}
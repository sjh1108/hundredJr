import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    static int max = 0;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        for(int i = 0; i < N; i++){
            if(i == 0) {
                start = arr[i];
                continue;
            }

            if(arr[i] > arr[i-1]){
                max = Math.max(max, arr[i] - start);
            } else {
                start = arr[i];
            }
        }
        System.out.println(max);
    }
}
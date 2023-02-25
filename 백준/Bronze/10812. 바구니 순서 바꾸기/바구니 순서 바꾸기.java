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
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        for(int i = 1; i <= N; i++){
            arr[i] = i;
        }

        M = Integer.parseInt(st.nextToken());
        while(M-- > 0){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int mid = Integer.parseInt(st.nextToken());

            reverse(start, end, mid);
        }


        for(int i = 1; i <= N; i++){
            sb.append(arr[i] + " ");
        }
        System.out.println(sb);
    }

    static void reverse(int start, int end, int mid){
        int[] o1 = Arrays.copyOfRange(arr, mid, end + 1);
        int[] o2 = Arrays.copyOfRange(arr, start, mid);

        for(int i = start; i <= start + (end - mid); i++){
            int j = i - start;
            arr[i] = o1[j];
        }

        for(int i = start + (end - mid) + 1; i <= end; i++){
            int j = i - (start + (end - mid) + 1);

            arr[i] = o2[j];
        }
    }
}
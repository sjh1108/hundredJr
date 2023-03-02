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
        arr = new int[N];
        int[] LIS = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        LIS[0] = arr[0];
        int len = 1;

        for(int i = 1; i < N; i++){
            int key = arr[i];

            if(LIS[len - 1] < key){
                LIS[len++] = key;
            }

            else{
                int lo = 0;
                int hi = len;

                while(lo < hi){
                    int mid = (lo + hi) / 2;

                    if(LIS[mid] < key){
                        lo = mid + 1;
                    }
                    else{
                        hi = mid;
                    }
                }

                LIS[lo] = key;
            }
        }

        System.out.println(len);
    }
}
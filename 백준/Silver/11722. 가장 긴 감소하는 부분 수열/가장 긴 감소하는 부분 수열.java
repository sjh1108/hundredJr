import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    static int[] arr, cnt;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        arr = new int[N+1];
        cnt = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        cnt[1] = 1;
        for(int i = 2; i <= N; i++){
            cnt[i] = 1;

            for(int j = 1; j < i; j++){
                if(arr[i] < arr[j] && cnt[i] < cnt[j] + 1){
                    cnt[i] = cnt[j] + 1;
                }
                else if(arr[i] == arr[j]){
                    cnt[i] = cnt[j];
                }
            }
        }

        int max = 0;
        for(int i = 1; i <= N; i++){
            max = Math.max(max, cnt[i]);
        }

        System.out.println(max);
    }
}
import java.io.*;
import java.util.*;

public class Main{
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N, M, K;

    static int[] arr, ar2;
    
    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        ar2 = new int[N+1];

        int cnt = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            ar2[i] = Integer.parseInt(st.nextToken());
            if(arr[i] == ar2[i]){
                cnt++;
            }
        }

        if(cnt == N){
            System.out.println(1);
            return;
        }
        int ans = 0;
        if(selection_sort()){
            ans = 1;
        }

        System.out.println(ans);
    }

    static boolean selection_sort(){
        for(int last = N; last > 1; last--){
            int max = 0, maxIdx = 0;

            for(int i = 1; i <= last; i++){
                if(arr[i] > max){
                    max = arr[i];
                    maxIdx = i;
                }
            }
            if(maxIdx != last){
                int temp = arr[maxIdx];
                arr[maxIdx] = arr[last];
                arr[last] = temp;
            }

            boolean flag = true;
            for(int i = 1; i <= N; i++){
                if(arr[i] != ar2[i]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                return true;
            }
        }

        return false;
    }
}
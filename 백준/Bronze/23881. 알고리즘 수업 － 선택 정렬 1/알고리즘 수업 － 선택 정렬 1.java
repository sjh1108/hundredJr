import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        for(int i = 0; i < n; i++){
            int last = n-i-1;
            int max = -1;
            int idx = -1;
            for(int j = 0; j <= last; j++){
                if(arr[j] > max){
                    max=arr[j];
                    idx=j;
                }
            }

            if(idx == last) continue;
            else {
                int tmp = arr[last];
                arr[last] = arr[idx];
                arr[idx] = tmp;

                if(++cnt == m){
                    System.out.println(arr[idx] + " " + arr[last]);
                    return;
                }
            }
        }

        System.out.println(-1);
    }
}
import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        int cnt = 0;
        int left = 0;
        int right = N - 1;
        while(left < right){
            if(arr[left] + arr[right] == M){
                cnt++;
                left++;
                right--;
            }else if(arr[left] + arr[right] < M){
                left++;
            }else{
                right--;
            }
        }

        System.out.println(cnt);
    }
}
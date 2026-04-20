import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int min = arr[0];
        int day = 0, cnt = 0;
        
        for(int i = 1; i < n; i++){
            if(arr[i-1] <= arr[i] && min < arr[i]){
                while(arr[i] > arr[i-1]){
                    arr[i]--;
                    cnt++;
                }
                day++;
            }
        }
        
        System.out.println(cnt + " " + day);
    }
}
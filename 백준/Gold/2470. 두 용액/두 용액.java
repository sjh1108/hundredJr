import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;
        int l = 0, r = n-1;
        int[] result = new int[2];
        while(l < r){
            int sum = Math.abs(arr[l] + arr[r]);

            if(sum < min){
                result[0] = arr[l];
                result[1] = arr[r];
                min = sum;
            }

            if(arr[l] + arr[r] < 0){
                l++;
            } else{
                r--;
            }
        }

        System.out.println(result[0] + " " + result[1]);
    }
}
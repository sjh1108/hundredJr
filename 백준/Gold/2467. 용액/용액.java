import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0, r = N - 1;
        
        int min = Integer.MAX_VALUE;
        int minLeft = l, minRight = r;

        while(l < r){
            int sum = arr[l] + arr[r];
            if(Math.abs(sum) < Math.abs(min)){
                min = sum;
                minLeft = l;
                minRight = r;
            }

            if(sum < 0){
                l++;
            } else if(sum > 0){
                r--;
            } else{
                break;
            }
        }

        System.out.println(arr[minLeft] + " " + arr[minRight]);
    }
}
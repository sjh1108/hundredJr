import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        double mean = arr[N-1];
        int cnt = 1;
        boolean flag = true;
        for(int i = N-2; i >= 0; i--){
            if(arr[i] > arr[i+1] + L || arr[i] < arr[i+1] - L){
                flag = false;
                break;
            }

            if(mean >= arr[i] + L || mean <= arr[i] - L){
                flag = false;
                break;
            }

            mean = (mean * cnt + arr[i]) / (cnt+1);

            cnt++;
        }

        if(flag){
            System.out.println("stable");
        } else{
            System.out.println("unstable");
        }
    }
}
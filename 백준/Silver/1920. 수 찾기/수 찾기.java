import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int M;
    static long K;
    
    static int[] arr;
    static int[][] dp;


    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);


        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());



        for(int i = 0; i < M; i++){
            if(binarySearch(Integer.parseInt(st.nextToken()))){
                sb.append(1);
            } else{
                sb.append(0);
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    static boolean binarySearch(int key){
        
        int lo = 0; 
        int hi = arr.length - 1;

        while(lo <= hi){
            int mid = (lo + hi) / 2;

            if(key < arr[mid]){
                hi = mid - 1;
            } else if(key > arr[mid]){
                lo = mid + 1;
            }
            else{
                return true;
            }
        }

        return false;
    }
}
import java.io.*;
import java.util.*;

public class Main{
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N, M, K;

    static boolean[] arr;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        arr = new boolean[N+1];
        for(int i = 2; i < N+1; i++){
            boolean isPrime = true;
            for(int j = 2; j <= Math.sqrt(N); j++){
                if(arr[j] && i % j == 0){
                    isPrime = false;
                    break;
                }
            }
            
            if(isPrime){
                arr[i] = true;
                list.add(i);
                for(int j = 2; i*j < N+1; j++){
                    arr[i*j] = false;
                }
            }
        }

        int l = 0, r = 1, sum = 0, cnt = 0;
        while(l <= r && r <= list.size()){
            sum = 0;
            for(int i = l; i < r; i++){
                sum += list.get(i);
            }

            if(sum == N){
                cnt++;
                r++;
            }

            else if(sum < N){
                r++;
            }

            else{
                l++;
            }
        }

        System.out.println(cnt);
    }

}
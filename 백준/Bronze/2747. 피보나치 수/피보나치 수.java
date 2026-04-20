import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    public static void main(String[] args) throws IOException{

        N = Integer.parseInt(br.readLine());
        if(N == 1 || N == 0){
            System.out.println(N);
            return;
        }
        int[] arr = new int[46];
        arr[0] = 0; arr[1] = 1;
         
        for(int i = 2; i <= N; i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
        System.out.println(arr[N]);
    }
}
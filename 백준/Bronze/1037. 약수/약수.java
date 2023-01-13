import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int realNum = 0;
        long num = 1;
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        num = arr[n - 1] * arr[0];
        for(int i = 1; i < n; i++){
            if(num % arr[i] != 0){
                num *= arr[i];
            }
        }

        realNum = (int) num;

        System.out.println(realNum);
    }
}
import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, K;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        arr = new int[3];

        st = new StringTokenizer(br.readLine());

        arr[0] = Integer.parseInt(st.nextToken());
        arr[1] = Integer.parseInt(st.nextToken());
        arr[2] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        
        int sum = arr[0] + arr[1];

        if(sum <= arr[2]){
            sb.append(sum * 2 - 1);
        } else{
            sb.append(sum + arr[2]);
        }

        System.out.println(sb);
    }
}
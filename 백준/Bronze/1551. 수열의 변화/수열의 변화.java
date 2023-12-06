import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[size];
        st = new StringTokenizer(br.readLine(), ",");
        for(int i = 0; i < size; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while(time-- > 0){
            for(int i = 0; i < size - 1; i++){
                arr[i] = arr[i + 1] - arr[i];
            }
            size--;
        }
        
        for(int i = 0; i < size; i++){
            sb.append(arr[i]);
            if(i != size - 1) sb.append(",");
        }

        System.out.println(sb);
    }
}
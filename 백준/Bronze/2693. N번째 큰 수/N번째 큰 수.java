import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[10];
        
        while(n-- > 0){
            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < 10; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            sb.append(arr[7]);
            sb.append('\n');
        }

        System.out.println(sb);
    }
}

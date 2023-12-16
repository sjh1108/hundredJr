import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        int[] arr = new int[51];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            try{
                arr[Integer.parseInt(st.nextToken())]++;
            } catch(Exception e){
                continue;
            }
        }

        for(int i = 50; i >= 0; i--){
            if(arr[i] == i) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(-1);
    }
}
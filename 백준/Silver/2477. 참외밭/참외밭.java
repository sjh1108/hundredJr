import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        int[] arr = new int[6];
        int[] narr = new int[6];

        for(int i = 0; i < 6; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[i] = a;
            narr[i] = b;
        }
        int big = 0;
        int small = 0;
        
        int bx = 0, by = 0;
        int sx = 0, sy = 0;

        int t = 0, k = 0;
        for(int i = 0; i < 6; i++){
            t = i + 2;
            k = i + 3;
            if(t > 5) t -= 6;
            if(k > 5) k -= 6;
            
            int a = i + 1;
            if(a > 5) a -= 6;
            if(arr[i] == arr[t] && arr[a] == arr[k]){
                //sx sy
                sx = narr[t];
                sy = narr[a];

                //bx by
                if(i > 0) bx = narr[i - 1];
                else bx = narr[5];
                if(i > 1) by = narr[i - 2];
                else by = narr[i + 4];
                break;
            }
        }

        big = bx * by;
        small = sx * sy;

        count = big - small;

        n *= count;

        System.out.println(n);
    }
}
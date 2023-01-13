//import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        int x = Integer.parseInt(br.readLine());
        int[] arr = new int[x];
        int[] narr = new int[x - 1];
        arr[0] = Integer.parseInt(br.readLine());
        for(int i = 1; i < x; i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(arr[i] > arr[i - 1]) narr[i - 1] = arr[i] - arr[i - 1];
            else narr[i - 1] = arr[i - 1] - arr[i];
        }
        int a = narr[0];
        for(int  i = 1; i < x - 1; i++){
            a = gcd(narr[i], a);
        }

        for(int i = 2; i <= a / 2; i++){
            if(a % i == 0){
                sb.append(i).append(' ');
            }
        }
        sb.append(a);

        System.out.println(sb);
    }
    static int gcd(int p, int q){
        if(q == 0) return p;
        return gcd(q, p % q);
    }
}
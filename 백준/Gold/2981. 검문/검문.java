import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        int x = Integer.parseInt(br.readLine());

        int[] arr = new int[x];

        for(int i = 0; i < x; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int a = arr[1] - arr[0];

        for(int i = 2; i < x; i++){
            a = gcd(arr[i] - arr[i - 1], a);
        }

        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i = 2; i <= Math.sqrt(a); i++){
            if(i * i == a) list.add(i);
            else if(a % i == 0){
                list.add(i);
                list.add(a / i);
            }
        }

        Collections.sort(list);
        for(int val : list){
            sb.append(val).append(' ' );
        }
        sb.append(a);

        System.out.println(sb);
    }
    static int gcd(int p, int q){
        if(q == 0) return p;
        return gcd(q, p % q);
    }
}
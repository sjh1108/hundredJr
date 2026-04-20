import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    
    public static void main(String[] args) throws IOException {
        HashSet<Integer> set = new HashSet<>();

        int[] arr = new int[5];
        for(int i = 0; i < 5; i++){
            int a = Integer.parseInt(br.readLine());
            arr[i] = a;
            if(set.contains(a)){
                set.remove(a);
            } else{
                set.add(a);
            }
        }

        for(int i = 0; i < 5; i++){
            if(set.contains(arr[i])){
                System.out.println(arr[i]);
                break;
            }
        }
    }
}

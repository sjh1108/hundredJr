import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    public static void main(String[] args) throws IOException{
        String s = br.readLine();
        int[] arr = new int[s.length()];

        int sum = 0;
        for(int i = 0; i < s.length(); i++){
            arr[i] = s.charAt(i) - '0';
            sum += arr[i];
        }
        if(sum % 3 != 0 || !s.contains("0")){
            System.out.println(-1);
            return;
        }

        Arrays.sort(arr);
        for(int i = s.length() - 1; i >= 0; i--){
            System.out.print(arr[i]);
        }
    }
}
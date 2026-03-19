import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, K;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        String s = br.readLine();

        int count = 0;

        for(int i = 0; i < s.length(); i++){
            int c = s.charAt(i) - 65;

            if(c > 24) c--;
            if(c > 17) c--;

            c /= 3;
            count += c + 3;
        }

        System.out.println(count);
    }
}
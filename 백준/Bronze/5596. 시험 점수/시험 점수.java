import java.util.*;
import java.io.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int a = 0;
        for(int i = 0; i < 4; i++){
            a += Integer.parseInt(st.nextToken());
        }
        
        int b = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            b += Integer.parseInt(st.nextToken());
        }

        System.out.println(Math.max(a, b));
    }
}
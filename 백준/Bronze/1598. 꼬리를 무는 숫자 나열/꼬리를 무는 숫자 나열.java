import java.util.*;
import java.io.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int a1 = a / 4;
        int a2 = a % 4;
        if(a2 == 0) {
            a1--;
            a2 = 4;
        }

        int b1 = b / 4;
        int b2 = b % 4;
        if(b2 == 0) {
            b1--;
            b2 = 4;
        }

        System.out.println(Math.abs(a1 - b1) + Math.abs(a2 - b2));
    }
}
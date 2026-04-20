import java.util.*;
import java.io.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int cnt = 0;
    static int N;
    static int S;
    static int arr[];

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(br.readLine());

        int h = a + c / 60;
        int m = b + c % 60;

        if(m >= 60){
            m -= 60;
            h++;
        }
        if(h >= 24){
            h -= 24;
        }

        System.out.println(h + " " + m);
    }
}
//import java.util.*;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        int a = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 5; i++){
            a += (int) (Math.pow(Integer.parseInt(st.nextToken()), 2));
        }
        System.out.println(a % 10);

        //System.out.println(sb);
    }
}
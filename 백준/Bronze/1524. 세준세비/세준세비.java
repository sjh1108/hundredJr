import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    public static void main(String[] args) throws IOException{
        int K = Integer.parseInt(br.readLine());
        while(K-- > 0){
            solve();
        }
        System.out.println(sb);
    }

    static int a = Integer.MIN_VALUE, b = Integer.MIN_VALUE;
    static void input(){
        try{
            st = new StringTokenizer(br.readLine());
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                a = Math.max(a, Integer.parseInt(st.nextToken()));
            }
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                b = Math.max(b, Integer.parseInt(st.nextToken()));
            }
        }catch(IOException e){}
    }
    static void solve() throws IOException{
        br.readLine();
        a = Integer.MIN_VALUE; b = Integer.MIN_VALUE;

        input();

        if(b > a) sb.append("B");
        else sb.append("S");

        sb.append('\n');
    }
}
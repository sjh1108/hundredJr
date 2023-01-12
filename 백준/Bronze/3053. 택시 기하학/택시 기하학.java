//import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        
        double uclid = Math.pow(n, 2) * Math.PI;
        double taxi = Math.pow(n, 2) * 2;

        sb.append(uclid).append('\n').append(taxi);
        System.out.println(sb);
    }
}
import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        int[] x = new int[2];
        int[] y = new int[2];
        for(int ttt = 0; ttt < n; ttt++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[0] = Integer.parseInt(st.nextToken());
            y[0] = Integer.parseInt(st.nextToken());

            x[1] = Integer.parseInt(st.nextToken());
            y[1] = Integer.parseInt(st.nextToken());

            int count = 0;

            int deadLine = Integer.parseInt(br.readLine());
            int[] a = new int[deadLine];
            int[] b = new int[deadLine];
            int[] r = new int[deadLine];
            double start, end;
            for(int i = 0; i < deadLine; i++){
                st = new StringTokenizer(br.readLine());
                a[i] = Integer.parseInt(st.nextToken());
                b[i] = Integer.parseInt(st.nextToken());
                r[i] = Integer.parseInt(st.nextToken());
                
                start = Math.sqrt(Math.pow(x[0] - a[i], 2) + Math.pow(y[0] - b[i], 2));
                end = Math.sqrt(Math.pow(x[1] - a[i], 2) + Math.pow(y[1] - b[i], 2));

                if(r[i] > start && r[i] > end){
                    continue;
                }                
                else if(r[i] > start || r[i] > end){
                    count++;
                } else{
                    continue;
                }
            }
            sb.append(count).append('\n');
        }

        System.out.println(sb);
    }
}
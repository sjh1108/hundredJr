import java.io.*;
import java.util.*;

public class Main{
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N, M, K;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        double sum = 0;
        int cnt = 0;

        while(N-- > 0){
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            int gkrwja = Integer.parseInt(st.nextToken());
            String tjdwjString = st.nextToken();
            double tjdwjr = 0;
            switch(tjdwjString){
                case "A+":
                    tjdwjr = 4.3;
                    break;
                case "A0":
                    tjdwjr = 4.0;
                    break;
                case "A-":
                    tjdwjr = 3.7;
                    break;
                case "B+":
                    tjdwjr = 3.3;
                    break;
                case "B0":
                    tjdwjr = 3.0;
                    break;
                case "B-":
                    tjdwjr = 2.7;
                    break; 
                case "C+":
                    tjdwjr = 2.3;
                    break;
                case "C0":
                    tjdwjr = 2.0;
                    break;
                case "C-":
                    tjdwjr = 1.7;
                    break;
                case "D+": 
                    tjdwjr = 1.3;
                    break;
                case "D0":
                    tjdwjr = 1.0;
                    break;
                case "D-":
                    tjdwjr = 0.7;
                    break;
                case "F":
                    tjdwjr = 0.0;
                    break;
                    
            }

            sum += gkrwja * tjdwjr;
            cnt += gkrwja;
        }

        System.out.println(String.format("%.2f", sum / cnt));
    }
}
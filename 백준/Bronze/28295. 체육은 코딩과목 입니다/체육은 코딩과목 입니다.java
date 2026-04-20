import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, K;

    public static void main(String[] args) throws IOException {
        int state = 0;

        for(int i = 0; i < 10; i++){
            int n = Integer.parseInt(br.readLine());

            if(n == 1){
                state++;
            } else if(n == 2){
                state += 2;
            } else{
                state--;
                if(state < 0){
                    state = 3;
                }
            }

            state %= 4;
        }

        switch(state){
            case 0:
                sb.append('N');
                break;
            case 1:
                sb.append('E');
                break;
            case 2:
                sb.append('S');
                break;  
            case 3:
                sb.append('W');
                break;
        }
        System.out.println(sb);
    }

}
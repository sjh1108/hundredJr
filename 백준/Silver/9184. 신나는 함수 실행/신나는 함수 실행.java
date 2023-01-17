import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int M;
    static int[] f;
    static int[][][] far = new int[21][21][21];

    public static void main(String[] args) throws IOException{

        f = new int[3];
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i = 0; i < 3; i++){
                f[i] = Integer.parseInt(st.nextToken());
            }

            if(f[0] == -1 && f[1] == -1 && f[2] == -1){
                System.out.println(sb);
                System.exit(0);
            }

            // get answer
            int a = w(f[0], f[1], f[2]);

            sb.append('w').append('(');
            for(int i = 0; i < 3; i++){
                sb.append(f[i]);
                if(i < 2){
                    sb.append(", ");
                } else{
                    sb.append(')');
                }
            }
            sb.append(" = ");

            // print answer
            sb.append(a);

            sb.append('\n');
        }
    }

    static int w(int a, int b, int c){
        if(a <= 0 || b <= 0 || c <= 0) 
            return 1;
        if(a < 21 && b < 21 && c < 21){
            if(far[a][b][c] != 0) {
                return far[a][b][c];
            }
        }
        if(a > 20 || b > 20 || c > 20){
            far[20][20][20] = w(20, 20, 20);
            return far[20][20][20];
        }
        if(a < b && b < c){
            far[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
            return far[a][b][c];
        }   
        far[a][b][c] = w(a-1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1); 
        return far[a][b][c];
    }
}
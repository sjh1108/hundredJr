import java.util.*;
import java.io.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;

    static int Case;
    public static void main(String[] args) throws IOException{
        Case = Integer.parseInt(br.readLine());

        while(Case-- > 0){
            int len = Integer.parseInt(br.readLine());
            int[][] arr = new int[3][len + 1];

            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= len; i++){
                arr[0][i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= len; i++){
                arr[1][i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 1; i <= len; i++){
                for(int j = 0; j < 3; j++){
                    arr[j][i] = Math.max(arr[(j + 2) % 3][i - 1], arr[(j + 1) % 3][i - 1]) + arr[j][i];
                }
            }

            int max = Math.max(arr[0][len], Math.max(arr[1][len], arr[2][len]));

            sb.append(max + "\n");
        }

        System.out.println(sb);
    }

}
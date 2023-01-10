import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        int[] xy = new int[4];
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < 4; i++){
            xy[i] = Integer.parseInt(st.nextToken());
        }
        int a = Math.abs(xy[0] - xy[2]);
        int b = Math.abs(xy[1] - xy[3]);
        if(xy[0] < xy[2] && xy[1] < xy[3]){
            sb.append(Math.min(Math.min(a,b), Math.min(xy[0], xy[1])));
        } else{
            sb.append(Math.min(a, b));
        }

        System.out.println(sb);
    }
}
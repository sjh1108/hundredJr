import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        int x = 0, y = 0;
        int[] px = new int[3];
        int[] py = new int[3];

        for(int i = 0; i < 2; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            
            if(px[0] == 0) px[0] = x;
            else if(px[1] == 0 && px[0] != x){
                px[1] = x;
            }

            if(py[0] == 0) py[0] = y;
            else if(py[1] == 0 && py[0] != y){
                py[1] = y;
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        if(px[1] == 0) px[2] = x;
        else{
            if(x == px[0]) px[2] = px[1];
            else px[2] = px[0];
        }
        if(py[1] == 0) py[2] = y;
        else{
            if(y == py[0]) py[2] = py[1];
            else py[2] = py[0];
        }

        sb.append(px[2]).append(' ').append(py[2]);
        System.out.println(sb);
    }
}
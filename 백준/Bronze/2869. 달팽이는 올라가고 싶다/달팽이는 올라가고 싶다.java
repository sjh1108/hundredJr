import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //Scanner s = new Scanner(System.in);
        
        /*
        int a = s.nextInt();
        int b = s.nextInt();
        int v = s.nextInt();
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        
        int day = (v - b) / (a - b);

        if((v - b) % (a - b) != 0){
            day++;
        }
        System.out.println(day);


        //s.close();
    }
}

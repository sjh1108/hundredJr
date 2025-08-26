import java.util.*;
import java.io.*;

public class Main{
    private static int n1 = 0, n2 = 0, n3 = 0, n4 = 0;
    private static int point, time;
    private static int pGet, tGet;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        gameEnd();
        StringTokenizer st = new StringTokenizer(br.readLine());
        loop: for(int i = 0; i < N; i++){
            if(time > 240) gameEnd();
            int cmd = Integer.parseInt(st.nextToken());

            switch (cmd) {
                case 1:
                gameEnd();
                continue loop;
                case 2:
                if(pGet > 1) pGet >>= 1;
                else tGet += 2;
                break;
                case 4:
                time += 56;
                break;
                case 5:
                if(tGet > 1) --tGet;
                break;
                case 6:
                if(pGet < 32) pGet <<= 1;
                break;
                default:
                break;
            }
            point += pGet;
            time += tGet;
        }

        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);
        System.out.println(n4);
    }
    private static void gameEnd(){
        if(point >= 35 && point < 65){
            n1++;
        }
        if(point >= 65 && point < 95){
            n2++;
        }
        if(point >= 95 && point < 125){
            n3++;
        }
        if(point >= 125){
            n4++;
        }
        
        time = 0;
        point = 0;
        pGet = 1;
        tGet = 4;
    }
}
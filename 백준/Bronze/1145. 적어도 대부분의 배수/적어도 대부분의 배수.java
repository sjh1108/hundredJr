import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[5];
        for(int i = 0; i < 5; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int tmp = 1;
        boolean flag = true;
        while(flag){
            int chk = 0;

            for(int i = 0; i < 5; i++){
                if(tmp % arr[i] == 0){
                    chk++;
                }
            }

            if(chk >= 3){
                System.out.println(tmp);
                
                return;
            }

            tmp++;
        }
    }
}
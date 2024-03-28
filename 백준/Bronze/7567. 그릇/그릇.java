import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    static int[] arr, cnt;

    public static void main(String[] args) throws IOException{
        boolean flag = true;

        String s = br.readLine();
        int cur = -1;
        int size = 5;
        while(++cur < s.length()){
            size+=5;
            
            if(s.charAt(cur) == '('){
                if(flag) continue;
                else{
                    size+=5;
                    flag = true;
                }
            } else{
                if(flag){
                    if(cur == 0){
                        flag = false;
                        continue;
                    }
                    size+=5;
                    flag = false;
                }
            }
        }

        System.out.println(size);
    }
}
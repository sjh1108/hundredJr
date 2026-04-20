import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    public static void main(String[] args) throws IOException{
        int cnt = Integer.parseInt(br.readLine());
        
        int sum = 0;
        String s = br.readLine();
        for(int i = 0; i < cnt; i++){
            char c = s.charAt(i);

            switch(c){
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    sum++;
                    break;
            }
        } 

        System.out.println(sum);
    }
}
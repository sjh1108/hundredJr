import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int M;
    static int K;

    static int[] arr;

    public static void main(String[] args) throws IOException{
        String s = br.readLine();

        boolean isPel = true;

        for(int i = 0; i < s.length(); i++){
            int j = s.length() - (i + 1);

            if(i > j){
                break;
            }


            char a = s.charAt(i);
            char b = s.charAt(j);

            if(a != b){
                isPel = false;
                break;
            }
        }
        if(isPel){
            System.out.println(1);
        } else{
            System.out.println(0);
        }
    }

}
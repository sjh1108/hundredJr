//import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int a = 1;
        for(int i = 2; i <= N; i++){
            a *= i;
        }
        if(N == 0){
            a = 1;
        }
        System.out.println(a);
    }
}
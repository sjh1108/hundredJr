import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, K;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        if(a + b + c != 180){
            System.out.println("Error");
        } else{
            if(a == 60 && b == 60 && c == 60){
                System.out.println("Equilateral");
            } else if(a == b || b == c || c == a){
                System.out.println("Isosceles");
            } else{
                System.out.println("Scalene");
            }
        }
    }
}
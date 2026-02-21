import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Set<String> set = new HashSet<String>();
        for(int i = 0; i < N; i++){
            set.add(sc.next().trim());
        }

        for(int i = 0; i < N-1; i++){
            set.remove(sc.next().trim());
        }
        for(String s: set){
            System.out.println(s);
        }
        sc.close();
    }
}
import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<Integer> w = new ArrayList<>();
        List<Integer> k = new ArrayList<>();
        
        for(int i = 0; i < 10; i++)
            w.add(sc.nextInt());
        for(int i = 0; i < 10; i++)
            k.add(sc.nextInt());
        Collections.sort(w);
        Collections.sort(k);
        
        int a = w.get(9) + w.get(8) + w.get(7);
        int b = k.get(9) + k.get(8) + k.get(7);
        
        System.out.print(a + " " + b);
    }
}
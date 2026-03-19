import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        
        int N = s.nextInt();
        
        int[] x = new int[N];
        int[] y = new int[N];
        
        for(int i = 0; i < N; i++){
            x[i] = s.nextInt();
            y[i] = s.nextInt();
        }
        
        Arrays.sort(x);
        Arrays.sort(y);
        
        N--;
        System.out.print(Math.abs((x[N] - x[0]) * (y[N] - y[0])));
    }
}
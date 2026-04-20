import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        while(N-- > 0){
	        int n = sc.nextInt();
	        int t = sc.nextInt();
	        n -= t / 7;
	        n += t / 4;
	        
	        sb.append(n).append('\n');
        }
        
        System.out.println(sb);
    }
}
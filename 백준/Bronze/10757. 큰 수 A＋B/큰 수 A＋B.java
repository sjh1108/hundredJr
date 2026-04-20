import java.util.*;


public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        
        String a = s.next();
        String b = s.next();

        int max = Math.max(a.length(), b.length());

        int[] A = new int[max + 1];
        int[] B = new int[max + 1];

        for(int i = a.length() - 1, idx = 0; i >= 0; i--, idx++){
            A[idx] = a.charAt(i) - '0';
        }
        for(int i = b.length() - 1, idx = 0; i >= 0; i--, idx++){
            B[idx] = b.charAt(i) - '0';
        }

        for(int i = 0; i < max; i++){
            int value = A[i] + B[i];
            A[i] = value % 10;
            A[i + 1] += (value / 10);
        }
        if(A[max] != 0){
            System.out.print(A[max]);
        }
        for(int i = max - 1; i >= 0; i--){
            System.out.print(A[i]);
        }
        /*
        StringBuilder sb = new StringBuilder();
        if(A[max] != 0){
            sb.append(A[max]);
        }
        for(int i = max - 1; i >= 0; i--){
            sb.append(A[i]);
        }

        System.out.println(sb);
        */

        s.close();
    }
}

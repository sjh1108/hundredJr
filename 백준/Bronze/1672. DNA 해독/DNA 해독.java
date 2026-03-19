import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, K;

    public static void main(String[] args) throws IOException {
        br.readLine();
        String str = br.readLine();
        int size = str.length();
        int[] arr = new int[size];

        for(int i = 0; i < size; i++) {
            char c = str.charAt(i);
            switch(c){
                case 'A':
                    arr[i] = 0;
                    break;
                case 'G':
                    arr[i] = 1;
                    break;
                case 'C':
                    arr[i] = 2;
                    break;
                case 'T':   
                    arr[i] = 3;
                    break;
            }
        }
        while(size-- > 1) {
            int f = arr[size-1];
            int a = arr[size];

            arr[size-1] = getDNA(f, a);
        }

        switch(arr[0]){
            case 0:
                System.out.println("A");
                break;
            case 1:
                System.out.println("G");
                break;
            case 2:
                System.out.println("C");
                break;
            case 3:
                System.out.println("T");
                break;
        }
    }
    
    static int getDNA(int f, int a){
        if(f == a) return f;
        if((f == 0 && a == 1) || (f == 1 && a == 0)) return 2;
        if((f == 0 && a == 2) || (f == 2 && a == 0)) return 0;
        if((f == 0 && a == 3) || (f == 3 && a == 0)) return 1;

        if((f == 1 && a == 2) || (f == 2 && a == 1)) return 3;
        if((f == 1 && a == 3) || (f == 3 && a == 1)) return 0;

        if((f == 2 && a == 3) || (f == 3 && a == 2)) return 1;
        
        return -1;
    }
}
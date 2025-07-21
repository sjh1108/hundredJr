import java.util.*;
import java.io.*;

public class Main{
    private static int[] a = new int[]
    {3, 2, 1, 2, 4,
    3, 1, 3, 1, 1,
    3, 1, 3, 2, 1,
    2, 2, 2, 1, 2,
    1, 1, 1, 2, 2,
    1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        String s1 = st.nextToken().toUpperCase();
        String s2 = st.nextToken().toUpperCase();

        int min = Math.min(n, m);
        for(int i = 0; i < min; i++){
            sb.append(s1.charAt(i));
            sb.append(s2.charAt(i));
        }

        if(n == min){
            for(int i = min; i < m; i++){
                sb.append(s2.charAt(i));
            }
        } else{
            for(int i = min; i < n; i++){
                sb.append(s1.charAt(i));
            }
        }

        int[] arr = new int[n+m];
        for(int i = 0; i < n+m; i++){
            arr[i] = a[getIndex(sb.charAt(i))];
        }

        for(int size = n+m; size > 2; size--){
            for(int i = 0; i < size-1; i++){
                arr[i] = (arr[i] + arr[i+1]) % 10;
            }
        }

        int ans = arr[0] * 10 + arr[1];
        System.out.println(ans + "%");
    }

    private static int getIndex(char c){
        return c - 'A';
    }
}
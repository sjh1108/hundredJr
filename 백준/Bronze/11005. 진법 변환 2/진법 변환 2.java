import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, K;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        List<Character> list = new ArrayList<>();
        while(n > 0){
            if(n % b < 10){
                list.add((char) (n % b + '0'));
            } else{
                list.add((char) (n % b - 10 + 'A'));
            }

            n /= b;
        }

        for(int i = list.size() - 1; i >= 0; i--){
            sb.append(list.get(i));
        }

        System.out.println(sb);
    }
}
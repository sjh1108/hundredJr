import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] array = new int[N];
        st = new StringTokenizer(br.readLine());
        long result = 1;

        for(int i=0; i<N; i++){
            array[i] = Integer.parseInt(st.nextToken()) % M;
            result = (result * array[i]) % M;
        } System.out.println(result);
    }
}
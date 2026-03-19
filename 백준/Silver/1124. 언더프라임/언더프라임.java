import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    public static void main(String[] args) throws IOException{
        int cnt = 0;

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
        boolean[] isPrime = new boolean[b+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for(int i = 2; i <= b; i++){
            if(isPrime[i]){
                for(int j = i*2; j <= b; j+=i){
                    isPrime[j] = false;
                }
            }
        }

        for(int i = a; i <= b; i++){
            int tmp = i;

            LinkedList<Integer> list = new LinkedList<>();
            for(int j = 1; tmp != 1 && j < i; j++){
                if(!isPrime[j]) continue;

                if(tmp % j == 0){
                    tmp /= j;
                    list.add(j);

                    j = 1;
                }
            }

            if(isPrime[list.size()]) cnt++;
        }

        System.out.println(cnt);
    }
}
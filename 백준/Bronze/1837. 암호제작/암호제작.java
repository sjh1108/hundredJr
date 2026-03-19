import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N, M;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        BigInteger p = new BigInteger(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        
        boolean[] primes = new boolean[k + 1];
        primes[1] = true;
              
        for(int i = 2 ; i < k ; i++){
            if(primes[i]) continue; // 소수가 아닌(true) 수는 넘어가기
            BigInteger now = new BigInteger(Integer.toString(i));
            if(p.mod(now).compareTo(BigInteger.ZERO) == 0) {    // p를 now로 나눈 나머지가 0이면 
                System.out.println("BAD " + now);
                return;
            }
            for(int j = i + i ; j <= k ; j += i){ // i를 제외한 i의 배수 모두 체크하기
                primes[j] = true;
            }
        }
        System.out.println("GOOD");
    }
}
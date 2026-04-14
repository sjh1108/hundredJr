import java.io.*;
import java.math.BigInteger;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] inputs = new String[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            inputs[i] = st.nextToken();
        }
        Arrays.sort(inputs, (o1, o2) -> {
            BigInteger b1 = new BigInteger(o1 + o2);
            BigInteger b2 = new BigInteger(o2 + o1);

            return b2.compareTo(b1);
        });

        String ans = "";
        for(String str: inputs) ans += str;

        if(ans.charAt(0) == '0')
            System.out.println(0);
        else
            System.out.println(ans);
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        // 1-digit palindromes
        for (int n = 1; n <= 9; n++) {
            if (n < a || n > b) continue;
            if (isPrime(n)) sb.append(n).append('\n');
        }

        // The only even-length prime palindrome.
        if (a <= 11 && 11 <= b) {
            sb.append(11).append('\n');
        }

        // Generate odd-length palindromes: root + reverse(root / 10)
        for (int root = 10; ; root++) {
            int pal = makeOddPalindrome(root);
            if (pal > b) break;
            if (pal < a) continue;
            if (isPrime(pal)) sb.append(pal).append('\n');
        }

        sb.append(-1).append('\n');
        System.out.print(sb);
    }

    private static int makeOddPalindrome(int root) {
        int result = root;
        int x = root / 10;
        while (x > 0) {
            result = result * 10 + (x % 10);
            x /= 10;
        }
        return result;
    }

    private static boolean isPrime(int n) {
        if (n < 2) return false;
        if ((n & 1) == 0) return n == 2;
        if (n % 3 == 0) return n == 3;

        for (int i = 5; (long) i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }
}

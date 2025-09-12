import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    static final int MAX_N = 25;
    static final int MAX_A_VAL = 50000;
    static final int MAX_SUM = (MAX_N - 1) * 2 * MAX_A_VAL;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int tc = 1; tc <= T; ++tc) {
            solve(br, sb);
        }
        System.out.print(sb.toString());
    }

    public static void solve(BufferedReader br, StringBuilder sb) throws IOException {
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] A = new int[2 * N];
        for (int i = 0; i < 2 * N; ++i) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        int[] arr = new int[2 * N - 2];
        long totalSum = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = A[i + 2];
            totalSum += arr[i];
        }

        int halfN = N - 1;
        
        Bignum[] dp = new Bignum[halfN + 1];
        for (int i = 0; i <= halfN; i++) {
            dp[i] = new Bignum(MAX_SUM);
        }
        dp[0].setBit(0);

        Bignum temp = new Bignum(MAX_SUM); // 임시 객체 재사용으로 오버헤드 최소화
        for (int val : arr) {
            for (int cnt = halfN; cnt >= 1; cnt--) {
                // dp[cnt] |= (dp[cnt - 1] << val)
                temp.shiftLeft(dp[cnt - 1], val);
                dp[cnt].or(temp);
            }
        }
        
        int bestSum = 0;
        long halfSum = totalSum / 2;
        for (int i = (int)halfSum; i >= 0; --i) {
            if (dp[halfN].getBit(i)) {
                bestSum = i;
                break;
            }
        }

        List<Integer> group1 = new ArrayList<>();
        List<Integer> group2 = new ArrayList<>();
        
        int currentSum = bestSum;
        int currentCount = halfN;
        boolean[] used = new boolean[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            int val = arr[i];
            if (currentCount > 0 && currentSum >= val && dp[currentCount - 1].getBit(currentSum - val)) {
                used[i] = true;
                currentSum -= val;
                currentCount--;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (used[i]) {
                group1.add(arr[i]);
            } else {
                group2.add(arr[i]);
            }
        }

        Collections.sort(group1);
        group2.sort(Collections.reverseOrder());

        sb.append(A[0]);
        for (int val : group1) sb.append(' ').append(val);
        sb.append('\n');

        for (int i = 0; i < group2.size(); i++) sb.append(group2.get(i)).append(' ');
        sb.append(A[1]).append('\n');
    }

    // Bignum 클래스 (위에 정의된 내용)
    static class Bignum {
        final long[] words;
        final static int WORD_BITS = 64;

        public Bignum(int size) {
            this.words = new long[(size / WORD_BITS) + 1];
        }

        public void setBit(int bit) {
            int wordIdx = bit / WORD_BITS;
            int bitIdx = bit % WORD_BITS;
            if (wordIdx < words.length) {
                words[wordIdx] |= (1L << bitIdx);
            }
        }

        public boolean getBit(int bit) {
            int wordIdx = bit / WORD_BITS;
            int bitIdx = bit % WORD_BITS;
            if (wordIdx >= words.length) return false;
            return ((words[wordIdx] >> bitIdx) & 1) == 1;
        }

        public void or(Bignum other) {
            int n = Math.min(this.words.length, other.words.length);
            for (int i = 0; i < n; i++) {
                this.words[i] |= other.words[i];
            }
        }
        
        public void clear() {
            Arrays.fill(words, 0L);
        }

        public void shiftLeft(Bignum source, int shift) {
            this.clear();
            
            int wordShift = shift / WORD_BITS;
            int bitShift = shift % WORD_BITS;

            if (bitShift == 0) {
                for (int i = 0; i < source.words.length; i++) {
                    int destIdx = i + wordShift;
                    if (destIdx < this.words.length) {
                        this.words[destIdx] = source.words[i];
                    }
                }
            } else {
                for (int i = 0; i < source.words.length; i++) {
                    int destIdx1 = i + wordShift;
                    if (destIdx1 < this.words.length) {
                        this.words[destIdx1] |= (source.words[i] << bitShift);
                    }
                    
                    int destIdx2 = i + wordShift + 1;
                    if (destIdx2 < this.words.length) {
                        this.words[destIdx2] |= (source.words[i] >>> (WORD_BITS - bitShift));
                    }
                }
            }
        }
    }
}
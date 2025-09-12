import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.BitSet;

public class Solution {

    static final int MAX_SUM = 25 * 50000 + 1;

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

        // 1. 숫자들을 오름차순으로 정렬
        Arrays.sort(A);

        // 2. 가장 작은 두 수를 제외한 나머지 배열 생성
        int[] arr = new int[2 * N - 2];
        int totalSum = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = A[i + 2];
            totalSum += arr[i];
        }

        int halfN = N - 1;
        
        // 3. DP를 위한 BitSet 배열 초기화
        // dp[count]는 count개의 숫자로 만들 수 있는 합의 집합
        BitSet[] dp = new BitSet[halfN + 1];
        for (int i = 0; i <= halfN; i++) {
            dp[i] = new BitSet(totalSum + 1);
        }
        dp[0].set(0); // 0개의 숫자로 합 0을 만들 수 있음

        // 4. DP 실행
        for (int val : arr) {
            for (int cnt = halfN; cnt >= 1; cnt--) {
                // C++의 dp[cnt] |= dp[cnt-1] << val; 와 동일한 로직
                // dp[cnt-1]에 포함된 모든 합(i)에 대해, dp[cnt]에 (i + val)을 추가
                BitSet shifted = new BitSet(totalSum + 1);
                for (int i = dp[cnt - 1].nextSetBit(0); i >= 0; i = dp[cnt - 1].nextSetBit(i + 1)) {
                    shifted.set(i + val);
                }
                dp[cnt].or(shifted);
            }
        }
        
        // 5. 최적의 부분합 찾기 (전체 합의 절반에 가장 가까운)
        int bestSum = 0;
        int halfSum = totalSum / 2;
        for (int i = halfSum; i >= 0; --i) {
            if (dp[halfN].get(i)) {
                bestSum = i;
                break;
            }
        }

        // 6. 역추적을 통해 두 그룹 생성
        List<Integer> group1 = new ArrayList<>();
        List<Integer> group2 = new ArrayList<>();
        
        int currentSum = bestSum;
        int currentCount = halfN;

        for (int i = arr.length - 1; i >= 0; i--) {
            int val = arr[i];
            if (currentCount > 0 && currentSum >= val && dp[currentCount - 1].get(currentSum - val)) {
                group1.add(val);
                currentSum -= val;
                currentCount--;
            } else {
                group2.add(val);
            }
        }

        // 7. 출력 형식에 맞게 정렬
        Collections.sort(group1);
        Collections.sort(group2, Collections.reverseOrder());

        // 8. 결과 출력
        sb.append(A[0]).append(' ');
        for (int val : group1) {
            sb.append(val).append(' ');
        }
        sb.append('\n');

        for (int val : group2) {
            sb.append(val).append(' ');
        }
        sb.append(A[1]).append(' ');
        sb.append('\n');
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 재료의 수
            int L = Integer.parseInt(st.nextToken()); // 제한 칼로리

            int[][] ingredients = new int[N][2]; // [0]: 맛 점수, [1]: 칼로리
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                ingredients[i][0] = Integer.parseInt(st.nextToken());
                ingredients[i][1] = Integer.parseInt(st.nextToken());
            }

            int maxScore = 0;

            // 1개부터 N개까지 재료를 선택하는 모든 경우를 탐색
            for (int k = 1; k <= N; k++) {
                // 선택할 재료를 표시하는 배열 (selector)
                // N-k개의 0과 k개의 1로 초기화 (예: N=5, k=3 -> [0, 0, 1, 1, 1])
                int[] selector = new int[N];
                for (int i = 0; i < k; i++) {
                    selector[N - 1 - i] = 1;
                }

                // do-while 루프를 사용하여 현재 조합부터 시작해 모든 조합을 순회
                do {
                    int currentScore = 0;
                    int currentCalories = 0;

                    // selector 배열을 기준으로 선택된 재료들의 점수와 칼로리를 합산
                    for (int i = 0; i < N; i++) {
                        if (selector[i] == 1) { // 1로 표시된 재료만 선택
                            currentScore += ingredients[i][0];
                            currentCalories += ingredients[i][1];
                        }
                    }

                    // 제한 칼로리 이하인 경우, 최대 점수 갱신
                    if (currentCalories <= L) {
                        maxScore = Math.max(maxScore, currentScore);
                    }
                } while (nextPermutation(selector)); // 다음 조합(순열)을 생성
            }

            System.out.println("#" + test_case + " " + maxScore);
        }
    }

    /**
     * Next Permutation 알고리즘
     * @param arr 순열을 생성할 배열
     * @return 다음 순열이 존재하면 true, 마지막 순열이면 false 반환
     */
    public static boolean nextPermutation(int[] arr) {
        int n = arr.length;

        // 1. 뒤에서부터 탐색하며 교환할 위치(i-1) 찾기 (arr[i-1] < arr[i]인 첫 위치)
        int i = n - 1;
        while (i > 0 && arr[i - 1] >= arr[i]) {
            i--;
        }

        // i가 0이면 마지막 순열이므로 false 반환
        if (i <= 0) {
            return false;
        }

        // 2. i-1 위치의 값과 교환할, 더 큰 값(j)을 뒤에서부터 찾기
        int j = n - 1;
        while (arr[j] <= arr[i - 1]) {
            j--;
        }

        // 3. i-1 위치와 j 위치의 값을 교환
        swap(arr, i - 1, j);

        // 4. i 위치부터 마지막까지의 원소들을 오름차순으로 정렬 (뒤집기)
        int k = n - 1;
        while (i < k) {
            swap(arr, i, k);
            i++;
            k--;
        }

        return true;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Solution {

    private static int N, L;
    private static Ingredient[] ingredients;
    private static int maxScore;

    static class Ingredient {
        int score;
        int calorie;

        public Ingredient(int score, int calorie) {
            this.score = score;
            this.calorie = calorie;
        }
    }

    private static void swap(int[] p, int a, int b) {
        int temp = p[a];
        p[a] = p[b];
        p[b] = temp;
    }

    private static boolean nextPermutation(int[] p) {
        int i = N - 1;
        while (i > 0 && p[i - 1] >= p[i]) {
            i--;
        }

        if (i == 0) {
            return false;
        }

        int j = N - 1;
        while (p[i - 1] >= p[j]) {
            j--;
        }

        swap(p, i - 1, j);

        int k = N - 1;
        while (i < k) {
            swap(p, i++, k--);
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            ingredients = new Ingredient[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int score = Integer.parseInt(st.nextToken());
                int calorie = Integer.parseInt(st.nextToken());
                ingredients[i] = new Ingredient(score, calorie);
            }

            maxScore = 0;

            for (int k = 1; k <= N; k++) {
                int[] selector = new int[N];
                
                for (int i = 0; i < k; i++) {
                    selector[N - 1 - i] = 1;
                }

                do {
                    int currentScore = 0;
                    int currentCalories = 0;

                    for (int i = 0; i < N; i++) {
                        if (selector[i] == 1) {
                            currentScore += ingredients[i].score;
                            currentCalories += ingredients[i].calorie;
                        }
                    }

                    if (currentCalories <= L) {
                        maxScore = Math.max(maxScore, currentScore);
                    }

                } while (nextPermutation(selector));
            }
            
            sb.append(maxScore).append("\n");
        }
        System.out.print(sb);
    }
}
import java.util.*;

class Solution {
    static int maxSubscribers = 0;
    static int maxTotalSales = 0;
    static int[] discountRates = {10, 20, 30, 40};
    static int[] currentDiscounts;
    static int[][] globalUsers;
    static int[] globalEmoticons;

    public int[] solution(int[][] users, int[] emoticons) {
        globalUsers = users;
        globalEmoticons = emoticons;
        currentDiscounts = new int[emoticons.length];

        dfs(0);

        return new int[]{maxSubscribers, maxTotalSales};
    }

    public void dfs(int depth) {
        if (depth == globalEmoticons.length) {
            calculateResult();
            return;
        }

        for (int i = 0; i < 4; i++) {
            currentDiscounts[depth] = discountRates[i];
            dfs(depth + 1);
        }
    }

    public void calculateResult() {
        int currentSubscribers = 0;
        int currentSales = 0;
        
        for (int[] user : globalUsers) {
            int userMinDiscount = user[0];
            int userPriceLimit = user[1];
            int userPurchaseAmount = 0;

            for (int i = 0; i < globalEmoticons.length; i++) {
                if (currentDiscounts[i] >= userMinDiscount) {
                    userPurchaseAmount += globalEmoticons[i] * (100 - currentDiscounts[i]) / 100;
                }
            }

            if (userPurchaseAmount >= userPriceLimit) {
                currentSubscribers++;
            } else {
                currentSales += userPurchaseAmount;
            }
        }

        if (currentSubscribers > maxSubscribers) {
            maxSubscribers = currentSubscribers;
            maxTotalSales = currentSales;
        } else if (currentSubscribers == maxSubscribers) {
            maxTotalSales = Math.max(maxTotalSales, currentSales);
        }
    }
}
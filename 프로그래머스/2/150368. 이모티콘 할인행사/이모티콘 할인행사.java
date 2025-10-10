import java.util.*;

class Solution {
    // 1. 목표: [최대 가입자 수, 최대 판매액]
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

        // DFS를 통해 모든 할인율 조합 탐색 시작
        dfs(0);

        return new int[]{maxSubscribers, maxTotalSales};
    }

    // depth는 현재 할인율을 결정할 이모티콘의 인덱스
    public void dfs(int depth) {
        // [종료 조건] 모든 이모티콘의 할인율이 결정되었을 때
        if (depth == globalEmoticons.length) {
            calculateResult();
            return;
        }

        // [재귀 호출] 현재 이모티콘(depth)에 4가지 할인율을 각각 적용
        for (int i = 0; i < 4; i++) {
            currentDiscounts[depth] = discountRates[i];
            dfs(depth + 1);
        }
    }

    // 하나의 할인율 조합이 완성되었을 때, 가입자 수와 판매액을 계산하는 함수
    public void calculateResult() {
        int currentSubscribers = 0;
        int currentSales = 0;

        // 모든 유저를 순회
        for (int[] user : globalUsers) {
            int userMinDiscount = user[0];
            int userPriceLimit = user[1];
            int userPurchaseAmount = 0;

            // 유저가 이모티콘들을 얼마나 구매하는지 계산
            for (int i = 0; i < globalEmoticons.length; i++) {
                if (currentDiscounts[i] >= userMinDiscount) {
                    userPurchaseAmount += globalEmoticons[i] * (100 - currentDiscounts[i]) / 100;
                }
            }

            // 구매액이 기준을 넘으면 가입, 아니면 구매
            if (userPurchaseAmount >= userPriceLimit) {
                currentSubscribers++;
            } else {
                currentSales += userPurchaseAmount;
            }
        }

        // 계산된 결과를 전역 최댓값과 비교하여 업데이트
        if (currentSubscribers > maxSubscribers) {
            maxSubscribers = currentSubscribers;
            maxTotalSales = currentSales;
        } else if (currentSubscribers == maxSubscribers) {
            maxTotalSales = Math.max(maxTotalSales, currentSales);
        }
    }
}
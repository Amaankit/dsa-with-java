package dp;

import java.util.Arrays;



public class Template {

    public static void main(String[] args) {
        int[] coins = new int[]{2, 6, 6};
        int amount = 16;

        int recursive = minCoin(coins, amount);
        System.out.println("Recursive: " + recursive);

        int dp = minCoinDP(coins, amount);
        System.out.println("DP (Memoization): " + dp);

        int tab = minCoinTabulation(coins, amount);
        System.out.println("Tabulation: " + tab);
    }


    public static int solution(int[] coins, int target, int length) {
        return 1;
    }

    public static int minCoin(int[] coins, int amount) {
        return 1;
    }


    public static int solutionDP(int[] coins, int target, int length, int[] dp) {
        return 1;
    }

    public static int minCoinDP(int[] coins, int amount) {
        return 1;
    }


    public static int solutionTabulation(int[] coins, int target) {
        return 1;
    }

    public static int minCoinTabulation(int[] coins, int amount) {
        return 1;
    }
}

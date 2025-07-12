package dp;

import java.util.Arrays;

// f(n) = (n-1) * (f(n-1) + f(n-2))
public class CountOfDeArangement {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 6, 6};


        int recursive = countOfArangement(arr);
        System.out.println("Recursive: " + recursive);

        int dp = countOfArangementDP(arr);
        System.out.println("DP (Memoization): " + dp);

        int tab = countOfArangementTabulation(arr);
        System.out.println("Tabulation: " + tab);
    }


    public static int solution(int n) {
        if(n==1){
            return 0;
        }
        if(n==2){
            return 1;
        }

        return (n-1) * (solution(n-1)+solution(n-2));
    }

    public static int countOfArangement(int[] coins) {
        return solution(coins.length);
    }


    public static int solutionDP(int n, int[] dp) {
        if(n==1){
            return 0;
        }
        if(n==2){
            return 1;
        }
        if(dp[n]!=-1){ return dp[n];  }

        dp[n] =  (n-1) * (solutionDP(n-1,dp)+solutionDP(n-2,dp));
        return dp[n];
    }

    public static int countOfArangementDP(int[] coins) {
        int[] dp = new int[coins.length + 1];
        Arrays.fill(dp, -1);
        return solutionDP(coins.length,dp);

    }


    public static int solutionTabulation(int[] coins) {
        return 1;
    }

    public static int countOfArangementTabulation(int[] coins) {
        return 1;
    }
}

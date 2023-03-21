package javaDev.algo;

import java.util.Arrays;

public class dpCoinChange {

    private int dpCoinChange(int[] coins,int sum){
        int dp[][] = new int[coins.length+1][sum+1];
        for(int i=0;i<=coins.length;i++){
            for(int j=0;j<=sum;j++){
                if (i==0)
                    dp[i][j] = 100;
                else if(j==0)
                    dp[i][j] = 0;
                else if(coins[i-1]>j) //i>j
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
            }
        }

        return dp[coins.length][sum];

    }

    private int dpCoinChange1D(int[] coins,int sum){
        int[] dp = new int[sum+1];
        Arrays.fill(dp,sum+1);
        dp[0] = 0;
        for(int i=1;i<=sum;i++){
            for(int coin=0;coin<coins.length;coin++){
                if(i-coins[coin]>=0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[coin]]);
                }
            }
        }


        return dp[dp.length-1];

    }


    public void doPerformAction(){
        int coins[] = {1,2,5};
        System.out.println(dpCoinChange(coins,5));
        System.out.println(dpCoinChange1D(coins,5));
    }

}

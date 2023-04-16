package javaDev.algo;

import java.util.Arrays;

public class DPDiceThrow {



    private int doDPXPlusPreviousDiceRollValues(int n,int f,int s){
        int dp[][] = new int[n][s+1];
       // Arrays.fill(dp[0],1);
        for(int i=1;i<=n && i<s;i++)
            dp[0][i] = 1;
        dp[0][0] = 0;
        for(int i=1;i<n;i++){
            Arrays.fill(dp[i],0);
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<=s;j++) {
                int res = 0;
                for(int k=1;k<=n && k<j;k++){
                    res += dp[i-1][j-k];
                }
                dp[i][j] = res;
            }
        }

        return dp[n-1][s];
    }



    private int doDPSpendAValueWithCurrentDiceAndRestFromPrevious(int n,int f,int s) {
        int dp[][] = new int[n+1][s+1];
        for(int i=0;i<=n;i++)
            Arrays.fill(dp[i],0);
        dp[0][0] = 1;
        for(int i=1;i<=n;i++)
            for(int j=i;j<=s;j++){
                dp[i][j] = dp[i][j-1]+dp[i-1][j-1];

                if(j-f-1>=0){
                    System.out.println(j-f-1);
                    //j-f-1>=0
                    dp[i][j] -= dp[i-1][j-f-1];
                }

            }

        return dp[n][s];
    }

    private int doRecurse(int n,int f,int s){
//        recursive approach -
//
//                s1. if sum==0 return 1
//
//        s2 .if n<=0 return 0
//
//        s3. res=0, for i in range faces+1
//
//        s4.    res+= method(n-1,faces,sum-i)
//
//        s5. return res
        if(s==0 && n==0)
            return 1;
        if(n<=0)
            return 0;

        int res = 0;
        for(int i=1;i<=f;i++){
            res += doRecurse(n-1,f,s-i);
        }

        return res;
    }


    public void performAction(){
        System.out.println("dice rec "+doRecurse(2,3,3));
       // System.out.println("dice rec "+doDPXPlusPreviousDiceRollValues(3,7,19));
       // System.out.println("dice rec "+doDPXPlusPreviousDiceRollValues(2,6,12));
        System.out.println("dice rec "+doDPSpendAValueWithCurrentDiceAndRestFromPrevious(3,6,12));

    }
}

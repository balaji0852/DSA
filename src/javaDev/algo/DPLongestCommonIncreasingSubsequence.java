package javaDev.algo;

import java.lang.reflect.Array;
import java.util.Arrays;

public class DPLongestCommonIncreasingSubsequence {


    private int doDPLongestCommonIncreasingSubsequence(int[] a1,int[] a2){
        int dp[] = new int[a2.length];
        int current =  0;

        for(int i=0;i<a1.length;i++) {
            current = 0;
            for (int j = 0; j < a2.length; j++) {
                if (a1[i] == a2[j])
                    dp[j] = Math.max(current + 1, dp[j]);


                if (a1[i] > a2[j])
                    current = Math.max(dp[j], current);

            }

        }
            Arrays.sort(dp);
            return dp[dp.length - 1];

    }



    public void performAction(){

        int a[] = {1,2,4,5,6,0,1,3,4,5};
        int b[] = {5,4,3,1,0,6,5,4,2,1};
        System.out.println(" LCIS :"+doDPLongestCommonIncreasingSubsequence(a,b));
    }
}

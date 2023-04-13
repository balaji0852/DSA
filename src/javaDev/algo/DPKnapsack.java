package javaDev.algo;

import java.util.Arrays;

public class DPKnapsack {


    private int doRecursiveKnapsack(int[][] data,int sackLimit,int i){
//        q4. knapsack
//
//        requirement weights , values, sackLimit
//
//        2d array containing weights and values , current capacity, and i
//
//        s1. if reached i<0 or capacity<0 , base case return 0
//
//        s2. if capacity<weights[i] then decrement index and recurse
//
//        s3. else, now either capacity == weights or capacity<weights , so add (values+recurse to next i-1 and update the capacity)current weight and skip current weight and move next, find max out of this two. And return the max
        if(sackLimit==0 || i==0){
            return 0;
        }else if(sackLimit<data[0][i]){
            return doRecursiveKnapsack(data,sackLimit,i-1);
        }else{
            return Math.max(data[1][i]+doRecursiveKnapsack(data,sackLimit-data[0][i],i-1),doRecursiveKnapsack(data,sackLimit,i-1));
        }
    }




    private int doDPKnapsackUnbounded(int[] weights,int[] profits, int capacity){
        int[][] table = new int[weights.length+1][profits.length+1];

        for(int i=0;i<weights.length+1;i++){
            for(int j=0;j<capacity+1;j++) {
                if(i==0)
                    table[i][j] = -1;
                else if(j==0)
                    table[i][j] = 0;
                else if(i<j)
                    table[i][j] = table[i-1][j];
                else {
                    //System.out.println(profits[j - 1] + " " + j + " " + i + " " + (i - lengths[j - 1]));
                    table[i][j] = Math.max(table[i - 1][j], profits[j - 1] + table[i][i - weights[j - 1]]);
                }
                //System.out.print(table[i][j]);
                //System.out.print(" ");
            }
            //System.out.print("\n");
        }


        return table[profits.length][capacity];

    }


    private int doDPKnapsackUnbounded1D(int[] weights,int[] profits, int capacity) {
//        We have unlimited amount of items in each weights. So we can add n number of same weights for the capacity. Note that we use 1D array here which is different from classical knapsack where we used 2D array. Here number of items never changes. We always have all items available.
//
//        pseudo code:
//
//        step1: for i=1 in weights, dp[0] = 0
//
//        step2 : for j in weights
//
//        step3: if i-j>=0 then dp[i] = max(dp[i], profits[i-1]+dp[i-j])
//
//        step4: return dp[weights]
        int dp[] = new int[capacity+1];
        Arrays.fill(dp,0);
        for(int i=1;i<=capacity;i++){
            for(int weight=0;weight<weights.length;weight++){
                if(weights[weight]<i){//weights[weight]<=i){//both means the same, jsut wanted to use them
                    dp[i] = Math.max(dp[i],profits[weight]+dp[i-weights[weight]]);
                }
            }
//            for(int k=0;k<capacity+1;k++)
//                System.out.print(dp[k]+" ");
//            System.out.println("\n");
        }
        //0
        //0     1   2   3   4    5
        //1     5   3   8   11   18
        //2     0   3   8   11   18
        //3     0   0   8   13   18
        //4     0   0   0   13   18
        //5     0   0   0   0    18
        return dp[capacity];
    }


    private int doDPKnapsack01(int[] weights,int[] profits, int capacity) {
//        In 0 1 knapsack , dp approach : In a 2D there is limited items. In a DP[][] table let’s consider all the possible weights from ‘1’ to ‘W’ as the columns and the element that can be kept as rows.
//
//        psuedo code:
//
//        step1 : for i=0 to Weights.legnth
//
//        step2 :  for j = 0  to weights
//
//        step3 :              if (i==0 || j==0) then dp[i][j] = 0
//
//        step4:              else if (i>weights[j-1]) then dp[i][j] =  dp[i-1][j]
//
//        step5:              else dp[i][j] =  max(dp[i-1][j], profits[j-1]+dp[i][j-weights[i-1])
//
//        step6:   return dp[weight][weight]
        int dp[][] = new int[weights.length+1][capacity+1];
        for(int i=0;i< profits.length+1;i++){
            for(int j=0;j<capacity+1;j++){
                if(j==0 || i==0)
                    dp[i][j] = 0;
                else if(weights[i-1]>j) {
                    dp[i][j] = dp[i - 1][j];
                }
                else {
                    dp[i][j] =  Math.max( dp[i-1][j],profits[i-1]+dp[i-1][j-weights[i-1]]);
                }
            }

        }
//        0   0   0   0   0   0
//
//        0  60  60  60  60  60
//
//        0  60 100 160 160 160
//
//        0  60 100 120 180 220

        return dp[weights.length][capacity];
    }


    public void doPerformAction(){
        int data[][] = {{ 10, 20, 30 },{ 60, 100, 120}};
       //System.out.println(doRecursiveKnapsack(data,15,data[0].length-1));
       // System.out.println(doDPKnapsackUnbounded(data[0],data[1],5));
       System.out.println(doDPKnapsackUnbounded1D(data[0],data[1],50));
        System.out.println(doDPKnapsack01(data[0],data[1],50));
    }
}

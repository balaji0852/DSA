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
                System.out.print(table[i][j]);
                System.out.print(" ");
            }
            System.out.print("\n");
        }


        return table[profits.length][capacity];

    }


    private int doDPKnapsackUnbounded1D(int[] weights,int[] profits, int capacity) {
        int dp[] = new int[capacity+1];
        Arrays.fill(dp,0);
        dp[0] = 0;
        for(int i=0;i<capacity+1;i++){
            for(int weight=0;weight<=weights.length;weight++){
                if(weights[weight]<=i){//both means the same, jsut wanted to use them
                    dp[i] = Math.max(dp[i],profits[weight-1]+dp[i-weights[weight]]);
                }
            }
        }

        return 1;
    }

    public void doPerformAction(){
        int data[][] = {{1,2,3,4,5},{5,3,5,3,2}};
        System.out.println(doRecursiveKnapsack(data,10,data[0].length-1));
        //System.out.println(doDPKnapsackUnbounded(data[0],data[1],5));
        //System.out.println(doDPKnapsackUnbounded1D(data[0],data[1],5));
    }
}

package javaDev.algo;

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

    public void doPerformAction(){
        int data[][] = {{1,2,7,2,5},{5,3,5,3,2}};
        System.out.println(doRecursiveKnapsack(data,10,data[0].length-1));
    }
}

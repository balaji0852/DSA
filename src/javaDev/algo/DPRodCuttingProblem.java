package javaDev.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DPRodCuttingProblem {
//    q9.rod cutting problem
//
//    given a rod of length n , and sub length and their respective profits, find the maximum amount that can be formed using the given data. problem 1 - rod length = 5 , sublengths = [1,2,3,4,5] and subLengthRespectiveProfits = [5,3,7,10,11], knapsack recursive approach is first, then memo-dp, tabulation approach will be?
//
//    Tabulation : In tabulation approach, the given N will be made as columns and given items(weight, sub lengths, coins, eggs). And add the base case into the respective columns, and calculate the rest data.
//    lengths
//
//
//    formula - p(k) =max{ p(i)+p(j-i)}, c(i) = max{Vk + C(i-k)}
//
//    max profit (1) = 2
//
//    max profit (2) = {p2+p1(2+5=7), 5} = 7
//
//    max profit(3) = {p1+p2(2+7=9),p3(7),p2+p1(5+2=7)}  = 9
//
//    max profit(4) = max{ p1+p3(2+9=11),p2+p2(5+7=12),p3+p1(7+2=9),p4(10)} = 12
//
//    max profit(5) = max{p1+p4(2+12=14),p2+p3(5+9=14),p3+p2(7+7=14),p4+p1(10+2=12)} = 14
//
//    pseudo code: profits = {p1,p2,p3,p4,p5},length={l1,l2,l3,l4,l5} 1.
//
//            1.for i=1 in profits.length,
//
//            2.mem[0] = 0
//
//            4. for j=1 in n
//
//5.  curProfit = -inf
//
//6.                  for i=1 in j
//
//7.                     curProfit = max(curProfit, p[i]+r[j-i])
//
//8. mem[i] = curProfit
//
//9. return mem[n]
//
//    Recursive approach - rod cutting problem(top down by memoizing it)
//    methodX(profits,lengths,length,i)
//
//                              if(length=0 or i=0) return 0
//
//            else if (length<lengths[i]) return methodx(profits,lengths,length,i-1)
//
//                              else max(profits[i]+methodx(profits,lengths,length-lengths[i],i-    1),methodx(profits,lengths,length,i-1))
//


    private int doRodCuttingProblem(int[] profits,int[] lengths, int length , int i){
        if(length<=0 || i<0)
            return 0;
        else if(length<lengths[i])
            return doRodCuttingProblem(profits,lengths,length,i-1);
        else
            return Math.max(profits[i]+doRodCuttingProblem(profits,lengths,length-lengths[i],i-1),
                    doRodCuttingProblem(profits,lengths,length,i-1));
    }

    private int doDPRodCuttingProblem2D(int[] profits,int[] lengths, int length){
        int[][] table = new int[profits.length+1][length+1];

        for(int i=0;i<length+1;i++){
            for(int j=0;j<length+1;j++) {
                if(i==0)
                    table[i][j] = -1;
                else if(j==0)
                    table[i][j] = 0;
                else if(i<j)
                    table[i][j] = table[i-1][j];
                else {
                    //System.out.println(profits[j - 1] + " " + j + " " + i + " " + (i - lengths[j - 1]));
                    table[i][j] = Math.max(table[i - 1][j], profits[j - 1] + table[i][i - lengths[j - 1]]);
                }
                System.out.print(table[i][j]);
                System.out.print(" ");
            }
            System.out.print("\n");
        }


        return table[profits.length][length];

    }

    private int doDPRodCuttingProblem(int[] profits,int[] lengths, int length){
        int[] maxProfits = new int[lengths.length+1];
        Arrays.fill(maxProfits,lengths.length+1);
        int q = 0;
        maxProfits[0] = 0;
        for(int i=1;i<=lengths.length;i++){
            q = 0;
            for(int j=1;j<=i;j++){
                q = Math.max(q,profits[j-1]+maxProfits[i-lengths[j-1]]);
            }
            maxProfits[i] = q;
        }
        Arrays.sort(maxProfits);
        return maxProfits[lengths.length];
    }


    public void doPerformAction(){
        int[] profits = {1,5,8,9,10,17,17,20};
        int[] lengths ={1,2,3,4,5,6,7,8};
        System.out.println(doRodCuttingProblem(profits,lengths,8,lengths.length-1));
        System.out.println(doDPRodCuttingProblem(profits,lengths,8));
        System.out.println(doDPRodCuttingProblem2D(profits,lengths,8));
    }
    
    
}

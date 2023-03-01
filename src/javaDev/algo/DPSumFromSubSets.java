package javaDev.algo;
import java.util.*;
public class DPSumFromSubSets {



    private int doRecursiveSumFromSubSets(int a[],int total,int i){
        //q3. find subsets of a array whose sum is equal to give array. sol below
//        theory: finding a sum in a sub set, can be formed by n elements, we can add and skip the nth elements as per our required sum. If the nth element falls under sum adding it to the count, it will form the required sum from its subsets of array.
//
//        step 1. bases case if total==a[i] return 1<- when we have required sum for the given method call, add it to count.
//
//                s2. if total<0 return 0 ←. or subsets elements are larger than total
//
//        s3. if i<0 return 0<- before burning the total , we have completed with our index ex.[2,4,6] required sum 7. we reach -x in its recursions
//
//                [2,4,6],7,2
//
//                [2,4,6], 1, 1                                           [2,4,6], 7, 1
//
//                [2,4,6],1,0                                     0                         [2,4,6], 7, 0                         [2,4,6],1,0
//
//                [2,4,6], 1,-1                 0                                         [2,4,6], 7, -1        [2,4,6],5,-1            [2,4,6],1,-1
//
//        0                         0                                                     0                          0                          0
//
//        s4. if total<a[i], when given sum is less than given index, get into its sub array for sum
//
//        s5. else (when total==a[i] or total>=a[i]) break it further more by with and without a[i] adding to the count
        if (total==0){

            return 1;
        }
        else if (total<0){
            return 0;
        }
        else if(i<0){
            return 0;
        }
        else if(total<a[i]){
            return doRecursiveSumFromSubSets(a,total,i-1);
        }
        else{
            return doRecursiveSumFromSubSets(a,total,i-1)+doRecursiveSumFromSubSets(a,total-a[i],i-1);
        }
    }

    private void supportDp(int a[],int total,int i){
        HashMap<String,Integer> memoize = new HashMap<>();
        System.out.println("memoized solution");
        System.out.println(doDPSumFromSubSets(a,total,i,memoize));
    }

    //memoized
    private int doDPSumFromSubSets(int a[],int total,int i,HashMap<String,Integer> memoize){
        int result = 0;
        if(memoize.containsKey(total+"-"+i)){
            System.out.println("memoized");
            return memoize.get(total+"-"+i);
        }
        if (total==0){
            result =1;
        }
        else if (total<0){
            result = 0;
        }
        else if(i<0){
            result = 0;
        }
        else if(total<a[i]){
            result = doDPSumFromSubSets(a,total,i-1,memoize);
        }
        else{
            result = doDPSumFromSubSets(a,total,i-1,memoize)+doDPSumFromSubSets(a,total-a[i],i-1,memoize);
        }
        memoize.put(total+"-"+i,result);
        return result;
    }


    public void performAction(){
        int a[] = {2,4,6,10,16};
        System.out.println(doRecursiveSumFromSubSets(a,16,a.length-1));
        int b[] = {2,4,6,10};
        System.out.println(doRecursiveSumFromSubSets(b,16,b.length-1));
        supportDp(a,16,a.length-1);
        supportDp(b,16,b.length-1);
    }
}

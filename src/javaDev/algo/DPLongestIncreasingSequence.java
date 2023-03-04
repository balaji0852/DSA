package javaDev.algo;

import java.util.*;

public class DPLongestIncreasingSequence {
//    q4. find longest increasing subsequence(LIS)(dp solution)
//
//    Breaking the problem into sub problem. LIS[n] = 1+max{LIS[k] | k<n, A[k]<A[n]} , LIS of any item is LIS[item]<-that is LIS of LIS[item-1]+1 (but we can save it as LIS[item]).  By finding LIS for each item.
//
//    LIS = longest path in DAG + 1
//
//    ex. [3,1,8,2,5]
//
//    LIS[4] = 1+{LIS[3]={1+LIS[1]={1+LIS[0]=1}}}
//
//    All increasing subsequence are subsets of original sequence. All increasing subsequence have a start and end.
//
//    s1. Initialize a List of 1 of size inputArray.length
//
//    s2. run through the array till upto required number-n.
//
//            s2.1, for every element update the array for its max number sequence below it +1.

    //[2,4,1,2,8,3,5,1,9,8]
    private int doDPLongestIncreasingSequence(Integer[] a){
        List<Integer> A = new ArrayList<>(Arrays.asList(a));
        List<Integer> mem = new ArrayList<>(  Collections.nCopies(a.length,1));
        for(int i = 1;i<a.length;i++){
            List<Integer> subProblems = new ArrayList<>();
            for(int j=0;j<i;j++){
                if(A.get(j)<A.get(i))
                    subProblems.add(mem.get(j));
            }
            if(subProblems.size()>0)
                mem.set(i,1+Collections.max(subProblems));
//            System.out.println(mem);
        }
        return Collections.max(mem);
    }

    public void performAction(){


        System.out.println(doDPLongestIncreasingSequence(new Integer[]{2,4,1,2,8,3,5,1,9,10,23}));
        System.out.println(doDPLongestIncreasingSequence(new Integer[]{3,1,8,2,5}));

    }
}

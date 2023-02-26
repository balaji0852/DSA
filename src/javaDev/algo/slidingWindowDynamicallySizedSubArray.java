package javaDev.algo;

import java.util.*;

public class slidingWindowDynamicallySizedSubArray {



    private void doSlidingWindowDynamicallySizedSubArray(int a[],int desiredSum){
        //Given a array of positive integers, find the subarrays of integers that add up to a given number.
//        dynamically sized subarray
//        s1. currentSum = 0, leftIndex=0, int a[][], index - 0;
//        s2. iterate through out the array
//        s3. iterate and slide the left index , until currentSum>desiredSum
//        s3.1   currentSum -= currentIndex[leftIndex]; leftIndex++;   ,
//        s4. if currentSum equals desiredSum then a[0] = {leftIndex,i}


        int currentSum = 0, leftIndex = 0;
        List<Integer[]> result = new ArrayList<>();
        for(int i=0;i<a.length;i++){

            currentSum += a[i];

            while(currentSum>desiredSum){
                currentSum -= a[leftIndex];
                leftIndex++;
            }

            if(currentSum==desiredSum){
                result.add(new Integer[]{leftIndex,i});


            }

        }
        for(Integer[] j : result){
            System.out.println(j[0]+"   "+j[1]);

        }
    }




    public void performAction(){
        int[] a = {2,3,4,5,6,7,8,7,3,4,5,6,1,5,2};
        doSlidingWindowDynamicallySizedSubArray(a,7);
    }
}

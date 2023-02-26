package javaDev.algo;

public class slidingWindowStaticallySizedSubArray {




    public int doSlidingWindowOnStaticallySizedSubArray(int[] a,int size){
//        statically size sliding window, finding  Maximum average subarray of size of n?
//                s1: gimmickStartIndex = n, currentSum, leftIndex= 0,maxSubArrayAverage=0
//        s2. iterate i through the array upto max
//        s3.if i<n-1 then continue this currentSum += a[i]
//        s4 else currentSum -= a[i-gimmickStartIndex ], if (currentSum/n)>maxSubArrayAverage then maxSubArrayAverage = (currentSum/n) and make  leftIndex++;
//        s5. print(maxSubArrayAverage)
//        s6.print(a[leftIndex:leftIndex+4])

        int gimmickStartIndex = size,currentSum = 0,leftIndex = 0,maxSubArrayAverage = 0,left=0;

        for(int i=0;i<a.length;i++){
            currentSum += a[i];
            if(i<size){
                maxSubArrayAverage = currentSum/size;
            }else{
                currentSum -= a[i-gimmickStartIndex];

                if((currentSum/size)>maxSubArrayAverage){
                    maxSubArrayAverage = currentSum/size;
                    left = (i-gimmickStartIndex)+1 ;

                }
            }
        }
        for(int test=left;test<left+size;test++){
            System.out.print(a[test]+" ,");
        }
        System.out.println("--------");
        return maxSubArrayAverage;
    }


    public void performAction(){
        int a[] = new int[]{1000,2,1,2,3,100000,2,34,5566778,2,1,1,1,1,1,1000000000};
        System.out.println(doSlidingWindowOnStaticallySizedSubArray(a,2));
    }
}

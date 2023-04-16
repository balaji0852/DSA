package javaDev.algo;

public class waterTrappingProblem {
//    q12. water trapping problem.
//
//    given a array of values consider as index as x axis and the values as y axis, find the amount of water that can be trapped between each wells formed.
//
//    sol. Formula to find amount of water that can be stored in a index is min(leftMax,rightMax)-index -height. This can be approached in two different ways.
//        1. By calculating and storing, left max and right max of each index and calculating the result(this approach requires two loops, to obtain the left
//            max and right max’s). 2. By using two pointer method. having left and right max with the two pointer, if leftmax<rightmax, then amount of water
//    storage in that well is leftmax-height[curIndex] else rightmax-height[curIndex].


    private int doWaterTrappingProblem(int heights[]){
        int l=0, r = heights.length-1, leftMax = heights[l],rightMax = heights[r],sum=0;

        while(l<r){
            if(leftMax<rightMax){
                l++;
                leftMax = Math.max(leftMax,heights[l]);
                sum += leftMax-heights[l];
            }else{
                r--;
                rightMax = Math.max(rightMax,heights[r]);
                sum += rightMax-heights[r];
            }

        }

        return sum;
    }


    public void performAction(){
        int[]  heights = {3,0,3,1,3,1};
        System.out.println(doWaterTrappingProblem(heights));
    }


}

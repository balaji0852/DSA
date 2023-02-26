package main;

import javaDev.algo.slidingWindowDynamicallySizedSubArray;
import javaDev.algo.slidingWindowStaticallySizedSubArray;
import javaDev.algo.slidingWindowStringSearch;

public class hub {


    public static void main(String args[]){
        System.out.println("main-hub");
        slidingWindowStringSearch test = new slidingWindowStringSearch();
        test.performAction();

        slidingWindowStaticallySizedSubArray test1 = new slidingWindowStaticallySizedSubArray();
        test1.performAction();



        slidingWindowDynamicallySizedSubArray test2 = new slidingWindowDynamicallySizedSubArray();
        test2.performAction();
    }
}

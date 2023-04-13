package javaDev.algo;

import java.util.HashMap;

public class DPEggDropping {

    private int doDPEggDropping(int egg,int floor){
        int dp[][] = new int[egg+1][floor+1];

//        s1. dp[egg+1][floor+1]
//
//        s2. dp[i][0] , 0th floor is 0, and dp[i][1], 1st floor is 1.
//
//        s3. dp[1][k] = k, k is no. of floor.
//
//        s4. traverse the array and compute for each floor and eggs. And get the minimum trial for each floor and egg.

        for(int eggs=0;eggs<=egg;eggs++){
            dp[eggs][0] = 0;
            dp[eggs][1] = 1;
        }

        for(int floors=0;floors<=floor;floors++){
            dp[1][floors] = floors;
        }

        for(int eggs=2;eggs<=egg;eggs++) {
            for (int floors = 2; floors <= floor; floors++) {
                int min = 100000000;
                int localMin = min;
                for (int i = 1; i <= floors; i++) {
                    localMin = 1 + Math.max(dp[eggs - 1][floors - i], dp[eggs][i - 1]);
                    if (localMin < min)
                        min = localMin;
                }
                dp[eggs][floors] = min;
            }
        }



        return dp[egg][floor];
    }

    private int doEggDroppingRecursion(int egg, int floor, HashMap<String,Integer> memo){
        String key = egg+"-"+floor;

        if(memo.containsKey(key)) {
            System.out.println("mem");
            return memo.get(key);
        }

        if(floor==0 || floor==1)
            return floor;

        if(egg==1)
            return floor;

        int min = floor;
        for(int i=1;i<=floor;i++) {

            int localEggBreaks = doEggDroppingRecursion(egg - 1, i - 1,memo);
            int localEggDoesntBreak = doEggDroppingRecursion(egg, floor-i,memo);
            System.out.println(i+" eggs:"+(egg-1)+" floors:"+(i-1)+" "+localEggBreaks+", eggs:"+(egg)+" floors:"+(floor-i)+" "+localEggDoesntBreak);
            int localMin = 1 + Math.max(localEggBreaks,localEggDoesntBreak );

            if(localMin<min)
                min = localMin;
        }

        memo.put(key ,min);


        return min;
    }

    public void performAction(){
        HashMap<String ,Integer> memo = new HashMap<>();
        System.out.println("egg problem :"+doEggDroppingRecursion(2,100,memo));
        System.out.println("dp-egg problem :"+doDPEggDropping(100,10000));
    }
}

package javaDev.algo;

import java.util.*;

public class DPBoxStacking {

//    q5. dp box stacking
    private int doDPBoxStacking(List<List<Integer>> boxes){
//        let s be the set of all boxes that can be stacked above (li,wi,hi), height[li,wi,hi] = Hi + max{height(lj,wj,hj)ES}
//
//        s1. loop through the array
//
//        s2. add all the boxj which can be placed on top of boxi. result Into an array. max(array)+boxi(h)
        Map<String,Integer> mem = new HashMap<>();
        for(int h=0;h<boxes.size();h++){
            mem.put(boxes.get(h).get(0).toString()+" "+boxes.get(h).get(1)+" "+boxes.get(h).get(2), boxes.get(h).get(2));
        }
        for(int i=1;i<boxes.size();i++){
            int height=boxes.get(i).get(2),width=boxes.get(i).get(1),length=boxes.get(i).get(0);
            List<Integer> subProblems = new ArrayList<>();
            for(int j=0;j<i;j++){
                if(boxes.get(j).get(1)<width && boxes.get(j).get(0)<length)
                    subProblems.add(mem.get(boxes.get(j).get(0).toString()+" "+boxes.get(j).get(1)+" "+boxes.get(j).get(2)));
            }
            if(subProblems.size()>0) {
                String key = boxes.get(i).get(0).toString()+" "+boxes.get(i).get(1)+" "+boxes.get(i).get(2);
                mem.put(key, mem.get(key) + Collections.max(subProblems));
            }
        }

        int height = 0;
        for(int h=0;h<boxes.size();h++){
            if(height<mem.get(boxes.get(h).get(0).toString()+" "+boxes.get(h).get(1)+" "+boxes.get(h).get(2)))
                height = mem.get(boxes.get(h).get(0).toString()+" "+boxes.get(h).get(1)+" "+boxes.get(h).get(2));
        }


        return height;
    }

    public void performAction(){
        List<List<Integer>> data = new ArrayList<>();

        data.add(Arrays.asList(new Integer[]{1,2,2}));
        data.add(Arrays.asList(new Integer[]{2,3,2}));
        data.add(Arrays.asList(new Integer[]{5,5,3}));
//        data.add(Arrays.asList(new Integer[]{24,21,41}));
//        data.add(Arrays.asList(new Integer[]{4,2,4}));
        System.out.println("box");
        System.out.println(doDPBoxStacking(data));
    }
}

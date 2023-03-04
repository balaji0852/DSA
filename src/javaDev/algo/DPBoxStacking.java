package javaDev.algo;

import java.util.*;

public class DPBoxStacking {


    private int doDPBoxStacking(List<List<Integer>> boxes){
        Map<String,Integer> mem = new HashMap<>();
        for(int h=0;h<boxes.size();h++){
            mem.put(boxes.get(h).get(0).toString()+" "+boxes.get(h).get(1)+" "+boxes.get(h).get(2), boxes.get(h).get(2));
        }
        for(int i=1;i<boxes.size();i++){
            int height=boxes.get(i).get(2),width=boxes.get(i).get(1),length=boxes.get(i).get(0);
            List<Integer> subProblems = new ArrayList<>();
            for(int j=0;j<i;j++){
                if(boxes.get(j).get(1)<width && boxes.get(j).get(0)<length)
                    subProblems.add(boxes.get(j).get(2));
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

        data.add(Arrays.asList(new Integer[]{2,3,4}));
        data.add(Arrays.asList(new Integer[]{4,6,10}));
        data.add(Arrays.asList(new Integer[]{6,12,9}));
        data.add(Arrays.asList(new Integer[]{24,21,41}));
        data.add(Arrays.asList(new Integer[]{4,2,4}));

        System.out.println(doDPBoxStacking(data));
    }
}

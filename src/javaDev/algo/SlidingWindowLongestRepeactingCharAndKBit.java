package javaDev.algo;

import java.util.HashMap;

public class SlidingWindowLongestRepeactingCharAndKBit {

//    q6. dp - lrs(longest repeating char sequence)-and k bits problem

    private int doSlidingWindowLongestRepeactingCharAndKBit(int a[],int k){
//        formula -  sliding window approach - windowLenght-max(repeating char or 1’s)<= k, slide the window from left side.
//
//                s0. initialize curMaxSequence=0,  result=0, dictionaryA,leftIndex=0
//
//        s1.iterate i through the array or string
//
//        s1.2. update the dictionaryA counts , and curMaxSequence
//
//        s1.3. while !(windowLenght-max(repeating char or 0’s)<= k), then update dictionaryA with – , recalculate curMaxSequence ,and slide leftIndex++
//
//                s1.4. calculate result = max{result,(leftIndex-i)+1}
//
//        s2. result is the answer
        int curMaxSequence=0,result=0,leftIndex=0;
        HashMap<Integer,Integer> mem = new HashMap<>();
        mem.put(0,0);
        mem.put(1,0);
        for(int i=0;i<a.length;i++){
            mem.put(a[i],1+mem.get(a[i]));
            curMaxSequence = Math.max(curMaxSequence,mem.get(a[i]));

            while(((i-leftIndex)+1)-curMaxSequence>k ){

                        mem.put(a[leftIndex],mem.get(a[leftIndex])-1);


                leftIndex++;
            }

            result = Math.max(result,(i-leftIndex)+1);
        }

        return result;
    }


    private int doSlidingWindowLongestRepeactingCharAndKBitString(String a,int k){

        int curMaxSequence=0,result=0,leftIndex=0;
        HashMap<Character,Integer> mem = new HashMap<>();

        for(int i=0;i<a.length();i++){
            if(mem.containsKey(a.charAt(i)))
                mem.put(a.charAt(i),1+mem.get(a.charAt(i)));
            else
                mem.put(a.charAt(i),1);
            curMaxSequence = Math.max(curMaxSequence,mem.get(a.charAt(i)));

            while(((i-leftIndex)+1)-curMaxSequence>k ){
                mem.put(a.charAt(leftIndex),mem.get(a.charAt(leftIndex))-1);
                leftIndex++;
            }

            result = Math.max(result,(i-leftIndex)+1);
        }
        System.out.println("max"+curMaxSequence);

        return result;
    }



    public void performAction(){
        System.out.println("doSlidingWindowLongestRepeactingCharAndKBit");

        System.out.println(doSlidingWindowLongestRepeactingCharAndKBit(new int[]{0,1,0,1,0,0,1,0},2));
        System.out.println("-----------------");

        System.out.println(doSlidingWindowLongestRepeactingCharAndKBit(new int[]{0,1,0,1,0,0,1,1,0,0,1,0,1,1,1},2));
        System.out.println("-----------------");

        System.out.println(doSlidingWindowLongestRepeactingCharAndKBit(new int[]{1,0,0,0,1,0},2));
        System.out.println(doSlidingWindowLongestRepeactingCharAndKBitString("ABABBBBBBAAAAAAA",2));
        System.out.println(doSlidingWindowLongestRepeactingCharAndKBitString("CACAABBBAA",2));
        System.out.println(doSlidingWindowLongestRepeactingCharAndKBitString("010100110010111",2));
        System.out.println(doSlidingWindowLongestRepeactingCharAndKBitString("111100010001101100000",2));




    }
}

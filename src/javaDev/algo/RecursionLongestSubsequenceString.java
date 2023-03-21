package javaDev.algo;

import java.util.*;

public class RecursionLongestSubsequenceString {


    private int doRecursionLongestSubsequenceString(String text1,String text2,int n,int m){
        System.out.println("i am called");


        if(m<0 || n<0)
            return 0;
        else if(text1.charAt(n)==text2.charAt(m))
            return 1+doRecursionLongestSubsequenceString(text1,text2,n-1,m-1);


        return Math.max(doRecursionLongestSubsequenceString(text1,text2,n-1,m),
                doRecursionLongestSubsequenceString(text1,text2,n,m-1));
    }


    private int doDPLongestSubsequenceString(String text1,String text2,int n,int m,HashMap<String,Integer> mem){

        int result = 0;

        if(m<0 || n<0)
            return 0;
        if(mem.containsKey(n+" "+m)) {
            System.out.println("mem");

            return mem.get(n + " " + m);
        }
        else if(text1.charAt(n)==text2.charAt(m))
            result = 1+doRecursionLongestSubsequenceString(text1,text2,n-1,m-1);
        else
            result  = Math.max(doRecursionLongestSubsequenceString(text1,text2,n-1,m),
                doRecursionLongestSubsequenceString(text1,text2,n,m-1));
        mem.put(n+" "+m,result);
        System.out.println("i am called");
        return  result;
    }



    private int dpBackTracking(String text1,String text2){

        Integer mat[][] = new Integer[text2.length()+1][text1.length()+1];

        for(int i=0;i<text2.length()+1;i++){
            Integer[] temp = new Integer[text1.length()+1];
            Arrays.fill(temp,0);
            mat[i] = temp;
        }


        for(int i=text2.length()-1;i>=0;i--){
            for(int j=text1.length()-1;j>=0;j--){
                if(text2.charAt(i)==text1.charAt(j)){
                    mat[i][j] = mat[i+1][j+1]+1;
                }else{
                    mat[i][j] = mat[i][j+1]+mat[i+1][j];
                }
            }
        }



        return mat[0][0];
    }






    public void performAction(){

//        System.out.println(doRecursionLongestSubsequenceString("balajikumar","aaa",10,2));
       System.out.println("----------********************----------");
//        HashMap<String,Integer> mem = new HashMap<>();
//        System.out.println(doDPLongestSubsequenceString("aaaabbaaab","aaa",9,2,mem));
       System.out.println(dpBackTracking("balaji","balaji"));
        System.out.println(dpBackTracking("balajiisworking","balajiwork"));

    }
}

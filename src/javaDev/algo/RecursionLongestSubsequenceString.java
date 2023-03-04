package javaDev.algo;

public class RecursionLongestSubsequenceString {


    private int doRecursionLongestSubsequenceString(String text1,String text2,int n,int m){


        if(m<0 || n<0)
            return 0;
        else if(text1.charAt(n)==text2.charAt(m))
            return 1+doRecursionLongestSubsequenceString(text1,text2,n-1,m-1);


        return Math.max(doRecursionLongestSubsequenceString(text1,text2,n-1,m),
                doRecursionLongestSubsequenceString(text1,text2,n,m-1));
    }



    public void performAction(){
        System.out.println(doRecursionLongestSubsequenceString("balajikumar","aaa",10,2));
    }
}

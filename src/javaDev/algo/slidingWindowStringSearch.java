package javaDev.algo;


import java.util.HashMap;
import java.util.Map;

//difficulty - hard
//___________________________________________________________________________________________
//Given a string and n characters, find the shortest substring that contains all the given characters.
public class slidingWindowStringSearch {



//balajicharacters , chars = abc
    private String findSlidingWindowStringSearch(String inputString,String chars){
        //Store Start=0,end=0,moreToFind=inputString.length,leftIndex=0
        //run over the array till rightIndex(local var for iterator) = inputString.length-1, store the chars count in hashMap
        //          if current inputString[rightIndex] is present in hashMap
        //                    if hashMap[inputString[rightIndex]] exists
        //                              hashMap[inputString[rightIndex]]--
        //                  moreToFind--;
        //          if moreToFind==0(if found all the chars in substring and found more smaller inside the chars, try sliding window
        //                  and if missing existing char from chars, update the
        //                  while leftIndex<rightIndex && (slide the leftIndex if inputString[leftIndex] not in hashMap ||
        //                                                  slide the hashMap[inputString[leftIndex]]<0)
        //                              if inputString[leftIndex] exists in hasMap
        //                                        hashMap[inputString[leftIndex]]++;
        //                              leftIndex++;
        //          if start==0 or (leftIndex-rightIndex)<(Start-end)
        //                  Start = leftIndex;
        //                  end = rightIndex;
        //return the inputString(leftIndex,rightIndex);

        int Start = 0, end = 0, moreToFind = chars.length(), leftIndex = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for(int i = 0; i<chars.length();i++){
            if(hashMap.containsKey(chars.charAt(i))){
                hashMap.put(chars.charAt(i),hashMap.get(chars.charAt(i))+1);
            }else{
                hashMap.put(chars.charAt(i),1);
            }
        }

        for(int rightIndex = 0;rightIndex<inputString.length();rightIndex++){

            if(hashMap.containsKey(inputString.charAt(rightIndex))){
                if(hashMap.get(inputString.charAt(rightIndex))>0){
                    moreToFind--;
                }
                hashMap.put(inputString.charAt(rightIndex),hashMap.get(inputString.charAt(rightIndex))-1);
            }


            if(moreToFind==0) {

                char left = inputString.charAt(leftIndex);
                while (leftIndex<rightIndex && (!hashMap.containsKey(left) || hashMap.get(left) < 0)) {
                    if(hashMap.containsKey(left)){
                        hashMap.put(left,hashMap.get(left)+1);
                    }
                    leftIndex++;
                    left = inputString.charAt(leftIndex);
                }

                if(Start==0 || ((rightIndex-leftIndex)<(end-Start))){
                    Start = leftIndex;
                    end = rightIndex;
                }
            }


        }



        return inputString.substring(Start,end+1);
    }



    public void performAction(){

        System.out.println("findSlidingWindowStringSearch");
//        System.out.println(findSlidingWindowStringSearch("balajicharacters","abc"));
//        System.out.println(findSlidingWindowStringSearch("asb2.9d/d!304#b$%^%!ksd,2294iubasdmc","b$#2"));
        System.out.println(findSlidingWindowStringSearch("xyz","xyyzyzyx"));
//        System.out.println(findSlidingWindowStringSearch("balajia","aa"));
//        System.out.println(findSlidingWindowStringSearch("gho8cbb","bob"));

    }



}




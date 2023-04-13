package javaDev.ds;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class addSearchWordsDSTrie {

    class trie{

        Map<Character, trie> children = new HashMap<Character, trie>();

        boolean end ;
    }



    private boolean searchWords(String word,trie root){
        trie cur = root;
        for(int i=0;i<word.length();i++){
            if(!cur.children.containsKey(word.charAt(i))){
                return false;
            }
            if(cur.children.size()>0)
                cur = cur.children.get(word.charAt(i));
        }


        return cur.end;
    }

    private boolean searchWordsSkipDots(String word,trie root,int j){
        //dots can be matched to any char, and it is valid
        trie cur = root;
        for(int i=j;i<word.length();i++){
            if(word.charAt(i)=='.'){
                for(char c:cur.children.keySet()){
                    if(searchWordsSkipDots(word,cur.children.get(c), i+1))
                        return true;
                }
                return false;
            }
            if(!cur.children.containsKey(word.charAt(i))){
                return false;
            }
            cur = cur.children.get(word.charAt(i));
        }
        return cur.end;
    }









    private void addWords(String word,trie root){
        trie cur = root;
        for(int i=0;i<word.length();i++){
            if(!cur.children.containsKey(word.charAt(i))){
                cur.children.put(word.charAt(i),new trie());
            }
            cur = cur.children.get((word.charAt(i)));
        }
        cur.end = true;

    }


    public void performAction(){
        trie test = new trie();
        addWords("ba",test);
        addWords("balaji",test);
        System.out.println("  does cointains "+searchWords("balaji",test));
        System.out.println("  does cointains "+searchWordsSkipDots("ba...ji",test,0));
    }




}

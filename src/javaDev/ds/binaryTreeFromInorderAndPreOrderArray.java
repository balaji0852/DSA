package javaDev.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class binaryTreeFromInorderAndPreOrderArray {


    private tree createTree(List<Integer> preOrder,List<Integer> inOrder){
        if (preOrder.isEmpty() || inOrder.isEmpty())
            return null;

        tree  node = new tree();
        node.data = preOrder.get(0);
        int mid = inOrder.indexOf(preOrder.get(0));
        node.left = createTree(preOrder.subList(1,mid+1),inOrder.subList(0,mid));
        node.right = createTree(preOrder.subList(mid+1,preOrder.size()-1),inOrder.subList(mid,inOrder.size()-1));


        return node;
    }



    public void performAction(){
        int a[] = {3,9,20,15,7};
        int b[] = {9,3,15,20,7};

        List<Integer> preOrder = Arrays.asList(3,9,20,15,7);
        List<Integer> inOrder = Arrays.asList(9,3,15,20,7);
        tree node = createTree(preOrder,inOrder);
        System.out.println("treeeees");


    }
}

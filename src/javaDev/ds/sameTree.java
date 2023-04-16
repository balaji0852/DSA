package javaDev.ds;

import java.util.ArrayList;
import java.util.List;

public class sameTree {

    private boolean isSameTree(tree leftTree,tree rightTree){
        if(null==leftTree && null==rightTree)
            return true;

        if(null==leftTree || null==rightTree)
            return false;

        if(leftTree.data!=rightTree.data)
            return false;

        return (isSameTree(leftTree.left,rightTree.left) && isSameTree(leftTree.right,rightTree.right));
    }



    public void performAction(){
        sortedArrayToBST createTree = new sortedArrayToBST();
        int a[] = {1,2,3,4,5,6,7};
        tree test = createTree.doTree(a,0,a.length-1);
        int b[] = {1,2,3,4,5,5,5};
        tree test1 = createTree.doTree(b,0,b.length-1);

        System.out.println(" same tree-----");
        System.out.println(" same tree? :"+isSameTree(test,test));


        System.out.println(" serialize the tree-----");
        List<String> testString  = new ArrayList<>();
        serializeAndDeserializeTree sl = new serializeAndDeserializeTree();
        sl.serialize(testString,test);
        System.out.println(" serialized data :"+testString.toString());

        tree node = sl.deSerialize(testString,new tree());

        sl.serialize(testString,node);

        System.out.println(" deserialized data :"+testString.toString());


        maximumSumPath sum = new  maximumSumPath();
        tree counter = new tree();
        sum.findMaximumSumPath(node,counter);
        System.out.println(" maxmum sum :"+counter.data);


        maximumDepthOFBT maxDepth = new maximumDepthOFBT();
        tree depth = new tree();
        maxDepth.recursion(node,depth);
        System.out.println(" depth :"+depth.data);
        System.out.println(" depth bfs :"+maxDepth.bfs(node));

        System.out.println(" depth dfs : "+maxDepth.dfs(node));
        System.out.println(" depth DFS : "+maxDepth.DFS(node));


        flipEquivalentTree flip = new flipEquivalentTree();
        System.out.println(" flip : "+flip.doFlip(depth,new tree()));


        isSubTree isSub = new isSubTree();
        int c[] = {0,1,2,3,5,6,7};
        tree left = createTree.doTree(c,0,c.length-1);
        int d[] = {1,2,3};
        tree subtree = createTree.doTree(d,0,d.length-1);
        System.out.println(" isSub : "+isSub.doSubTree(left,subtree));

        tree root = new tree();
        tree parent = new tree();
        tree leftie = new tree();
        tree rightie = new tree();
        tree leftchild = new tree();
        leftchild.data = 0;
        leftie.data = 1;
        parent.data = 2;
        rightie.data = 3;
        leftie.left = leftchild;
        parent.left = leftie;
        parent.right = rightie;
        tree inorderBTLinkList = new BTToLinkedList().doBTToLinkedList(parent,root);
        tree inorderBTLinkListPre = new BTToLinkedList().doBTToLinkedListPreOrder(left);


        bfsOnTreeLevelOrderTraversal task16 = new bfsOnTreeLevelOrderTraversal();
        task16.performAction(subtree);
        task16.performAction(left);





    }
}

package javaDev.ds;

public class isSubTree {


    public boolean doSubTree(tree root, tree subtr){
        if(subtr==null)
            return true;
        if(root==null)
            return false;

        if(root.data!=subtr.data)
            return (doSubTree(root.right,subtr) || doSubTree(root.left,subtr));

        return (doSubTree(root.left,subtr.left) && doSubTree(root.right,subtr.right));
    }
}

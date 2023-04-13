package javaDev.ds;

public class flipEquivalentTree {



    public boolean doFlip(tree root,tree rootRight){
        if(null==root || null==rootRight)
            return (null==root && null==rootRight);
        boolean a = false;
        if(root.data!= rootRight.data)
            return false;

        a =  (doFlip(root.left,root.left) && doFlip(root.right,root.right));

        return (a || (doFlip(root.left,root.right) && doFlip(root.right,root.left)));
    }
}

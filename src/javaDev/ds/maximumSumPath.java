package javaDev.ds;

public class maximumSumPath {

    public int findMaximumSumPath(tree root,tree obj){
        if(null==root)
            return 0;


        int left = findMaximumSumPath(root.left,obj);
        int right = findMaximumSumPath(root.right,obj);
        left = Math.max(left,0);
        right = Math.max(right,0);

        if (obj.data<root.data+left+right)
            obj.data = root.data+left+right;

        return root.data+Math.max(left,right);
    }

}

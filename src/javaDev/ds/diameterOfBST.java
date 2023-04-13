package javaDev.ds;

public class diameterOfBST {



    private int dodiameter(tree node,tree obj){
        if(null==node){
            return 0;
        }

        int left = dodiameter(node.left,obj);
        int right = dodiameter(node.right,obj);

        if(1+left+right>obj.data)
            obj.data = 1+left+right;


        return 1+Math.max(left,right);

    }




    int performAction(tree node,tree obj){

        return dodiameter(node,obj);
    }
}

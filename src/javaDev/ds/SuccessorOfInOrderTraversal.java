package javaDev.ds;

public class SuccessorOfInOrderTraversal {

    private int doSuccessorOfInOrderTraversal(treeBi item){
        if(item==null)
            return item.data;

        if(item.right!=null && item.right.left!=null){
            return getLeftLeaveNode(item.right.left);
        }


        while(item.parent!=null){
            if (item.parent.data>item.data)
                return item.parent.data;

            item = item.parent;

        }
        return item.data;
    }



    private int getLeftLeaveNode(treeBi item){
        if(item.left==null){
            return item.data;
        }


        return getLeftLeaveNode(item.left);
    }

    public void performAction(){
        treeBi tree = new treeBi();
        tree.data = 20;
        treeBi tree1 = new treeBi();
        tree.left = tree1;
        tree1.parent = tree;
        tree1.data = 9;
        treeBi tree2 = new treeBi();
        tree2.data = 25;
        tree.right = tree2;
        tree2.parent = tree;
        treeBi tree3 = new treeBi();
        tree3.data = 5;
        tree3.parent = tree1;
        tree1.left = tree3;
        treeBi tree4 = new treeBi();
        tree4.data = 12;
        tree1.right = tree4;
        tree4.parent = tree1;
        treeBi tree5 = new treeBi();
        tree5.parent = tree4;
        tree5.data = 11;
        tree4.left = tree5;
        treeBi tree6 = new treeBi();
        tree6.data = 14;
        tree4.right = tree6;
        tree6.parent = tree4;

        System.out.println(doSuccessorOfInOrderTraversal(tree3));

    }



    public class treeBi {

        public int data;
        public treeBi  left;
        public treeBi  right;

        public treeBi parent = null;
    }
}

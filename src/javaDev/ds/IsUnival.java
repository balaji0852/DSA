package javaDev.ds;

public class IsUnival {


    private int findNoOfUnivalTrees(tree tree,test test){
//        trees
//
//        q1. given a tree find whether is it unival
//
//        A empty tree is unival. a tree with parent.val==left.val==right==val is unival.
//
//        design: pass an class with int, as param. helper method isUnival takes class-> if node=null class+1; return true
//
//        if left val or right val is null return false and make sure both equal parents, else class+1  return true;
//
//
//
//->main meth
//
//        s1. create the class
//
//        s2. pass class and root node
//
//                s3. func start if root==null then class.isUnival=true , return class.Sum+1
//
//        s4. class.Sum = func(root.left,class)+ func(root.right,class)
//
//        s4.1 flag = class.isUnival
//
//        s5. if class.isUnival!=null and root.left.data==root.data then flag = true
//
//        s6  if class.isUnival!=null and root.right.data==root.data then flag = true
//
//        s7 else flag = false ,set class.isUnival = false
//
//        s8 if flag then class.sum++
//
//        s9. return class
        //    1
        //  1    1
        //          2
        if (null==tree)
            return test.data+1;

        int sum = findNoOfUnivalTrees(tree.left,test)+findNoOfUnivalTrees(tree.right,test);
        boolean flag = false;
        if(null!=tree.left && tree.left.data==tree.data)
            flag = true;
        if(null!=tree.right && tree.right.data==tree.data && flag)
            flag = true;
        else
            flag = false;

        if(flag)
            return test.data+1+sum;

        return test.data+sum;

    }


    class test{
        int data = 0;
    }


    public void performAction(){
        tree parent = new tree();
        tree left = new tree();
        tree right = new tree();
        parent.data = 1;
        left.data = 1;
        right.data = 1;
        parent.right = right;
      //  parent.left = left;
        tree rightChild = new tree();
        rightChild.data = 2;
        //parent.right.right = rightChild;
        System.out.println(findNoOfUnivalTrees(parent,new test()));


        tree diameter = new tree();
        diameter.data = 1;
        System.out.println("dia");
        System.out.println(new diameterOfBST().performAction(parent,diameter));
        System.out.println("dia"+diameter.data);
    }
}



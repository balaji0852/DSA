package javaDev.algo;

import java.util.Arrays;

public class DSInvertBinaryTree {

    private int findSumOfAllSumFromLeaveToRoot(String parentVal,tree node){
//        pseudo code:
//
//        s1. parentVal,node
//
//        s2. if null==node.right && null==node.left return (int)parentVal
//
//        s3. return method(parentVal+node.data,node.right)+method(parentVal+node.data,node.left)
        if(null==node.right && null==node.left) {
            return Integer.parseInt(parentVal);
        }


        if(null==node.right && null!=node.left) {
            return findSumOfAllSumFromLeaveToRoot(parentVal+node.val,node.left);
        }

        if(null!=node.right && null==node.left) {
            return findSumOfAllSumFromLeaveToRoot(parentVal+node.val,node.right);
        }


        return findSumOfAllSumFromLeaveToRoot(parentVal+node.val,node.right)+
                findSumOfAllSumFromLeaveToRoot(parentVal+node.val,node.left);

    }
    private int findMinimumDPTriagle(int[][] t){
//        dp- technic solve for below array and find its minimum value for each indexes children, use the same go up the tree
//
//        psuedo code.
//
//        s1. dp[len(traingle)+1] init
//
//        s2.for i len(t)-1 to equal 0
//
//        s3.  for j in len t[i]
//
//        s4.    dp[j] = t[i][j] + min(dp[j],dp[j+1])
//
//        s5. return dp[0]
        int[] dp = new int[t.length+1];
        Arrays.fill(dp,0);

        for(int i=t.length-1;i>=0;i--)
            for(int j=0;j<t[i].length;j++)
                dp[j] = t[i][j] +  Math.min(dp[j],dp[j+1]);

        return dp[0];

    }


    private tree createBSTOutofArray(int[] a,int l,int r){
        if(l>r) return null;

        int m = (l+r)/2;

        tree node = new tree();
        node.val = a[m];
        node.left = createBSTOutofArray(a,l,m-1);
        node.right = createBSTOutofArray(a,m+1,r);


        return node;

    }

    private tree leftViewOfBST(tree node){
//        q6. left view of a bst
//
//        psuedo code
//
//        s1. if node==null return node;
//
//        s2.print node.val
//
//        s3. if node.right!null then return method(node.right)
//
//        s4.if node.left!null then return method(node.left)
//
//        s5. return node
        if(null==node) return node;

        System.out.println(node.val);

        if(null!=node.left) return leftViewOfBST(node.left);

        if(null!=node.right) return  leftViewOfBST(node.right);

        return node;
    }


    private tree mergeBinaryTree(tree node1,tree node2){
//        if both the nodes are empty then dont create return null
//
//        createdNode.val = node1.val if not null + node2.val if not null
//
//        createdNode.left = method(node1!=null?node1.left:node1,node2!=null?node2.left:node2)
//
//        createdNode.right = method(node1!=null?node1.right:node1,node2!=null?node2.right:node2)
//
//        return your created node

        if(null==node1 && null==node2)
            return null;

        tree tree = new tree();
        if(node1!=null)
            tree.val+= node1.val;
        if(node2!=null)
            tree.val+= node2.val;
//
        tree.left = mergeBinaryTree(null!=node1?node1.left:null,null!=node2?node2.left:null);
        tree.right = mergeBinaryTree(null!=node1?node1.right:null,null!=node2?node2.right:null);
//        tree.left = mergeBinaryTree(node1.left,node2.left);
//        tree.right = mergeBinaryTree(node1.right,node2.right);

        return tree;

    }

    private int countingGoodNodes(tree tree,int maxval){
//        q5.Count good nodes in a binary tree, a node is good if its greater than its predecessors-msn question.
//
//                pseudo code:
//
//        s1. if root is null return 0;
//
//        s2. if root.val > maxval then maxval = root.val,count = 1
//
//        s3. leftgoods = method(maxval,root.left), rightgoods = method(maxval,root.right)
//
//        s4. return count+leftgoods+rightgoods

        if(null==tree) return 0;
        int count =  0;
        if (tree.val >=maxval){
            maxval = tree.val;
            count++;
        }
        int leftGoods = countingGoodNodes(tree.left,maxval);
        int rightGoods = countingGoodNodes(tree.right,maxval);


        return count+leftGoods+rightGoods;

    }


    private void invertTree(tree tree){
        if (null==tree) return;

        tree temp = tree.left;
        tree.left = tree.right;
        tree.right = temp;

        invertTree(tree.left);
        invertTree(tree.right);

    }

    class balanced{
        Boolean balanced;
    }

    private int isBalanced(balanced balanced,tree tree){
        if (null==tree){
            balanced.balanced = true;
            return 0;
        }
        balanced balanced1=new balanced(),balanced2 = new balanced();
        int leftHeight = isBalanced(balanced1,tree.left);
        int rightHeight = isBalanced(balanced2,tree.right);
        balanced.balanced = (balanced1.balanced && balanced2.balanced && ((leftHeight-rightHeight)<=1 ));

        return Math.max(leftHeight,rightHeight)+1;
    }

    class tree{
        int val ;
        tree right;
        tree left;
    }

    public void performAction(){
        tree parent = new tree();
        tree lchild = new tree();
        tree rchild = new tree();
        tree rlchild = new tree();
        tree rrchild = new tree();
        tree lrchild = new tree();
        tree llchild = new tree();
        lchild.val = 1;
        lrchild.val = 2;
        llchild.val = 3;
        lchild.right = lrchild;
        lchild.left = llchild;

        rchild.val = 5;
        rlchild.val = 6;
        rrchild.val = 8;
        rchild.left = rlchild;
        rchild.right = rrchild;

        parent.left = lchild;
        parent.right = rchild;
        parent.val = 2;


        traverse(parent);
        invertTree(parent);
        traverse(parent);
        balanced balanced = new balanced();
        System.out.println("balance "+isBalanced(balanced,parent)+" is tree balanced "+balanced.balanced);
        System.out.println("count good nodes :"+countingGoodNodes(parent,parent.val));

        tree test = mergeBinaryTree(parent,parent.right);

        traverse(test);

        int a[] = {1,1,2,4,5,6,7,8,9,10};

        tree test1 = createBSTOutofArray(a,0,a.length-1);
        traverse(test1);

        System.out.println("left view");
        leftViewOfBST(test1);
        int t[][] = {{12},{13,23},{23,1,7}};
        System.out.println(" triagle min path"+findMinimumDPTriagle(t));

        int b[]= {1,2,3};
        tree test2 = createBSTOutofArray(b,0,b.length-1);
        System.out.println(" tree sum "+findSumOfAllSumFromLeaveToRoot(String.valueOf(test1.val),test1));

    }

    private void traverse(tree tree){
        if(null==tree) return;

        System.out.println(tree.val);
//        if(null!=tree.left)
//            System.out.println(tree.left.val);
//        if(null!=tree.right)
//            System.out.println(tree.right.val);

        traverse(tree.left);
        traverse(tree.right);



    }



}



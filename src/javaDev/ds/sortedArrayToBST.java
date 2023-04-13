package javaDev.ds;

public class sortedArrayToBST {

    public tree doTree(int[] a,int start,int end){

        if(start>end)
            return null;

        int mid = ((end+start)/2);

        tree node = new tree();
        node.data = a[mid];
        node.left = doTree(a,start,mid-1);
        node.right = doTree(a,mid+1,end);


        return node;

    }




    public void performAction(){
        int a[] = {1,2,3,4,5,6,7};
        tree test = doTree(a,0,a.length-1);
        System.out.println(" created tree: ");
        bfsOnTreeLevelOrderTraversal task16 = new bfsOnTreeLevelOrderTraversal();
        task16.performAction(test);


        int b[] = {1,2,3,4,5,5,5};
        tree test1 = doTree(b,0,b.length-1);


    }
}

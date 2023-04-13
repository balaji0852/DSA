package javaDev.ds;

public class BTToLinkedList {

    //converting BST to linked list, In in order traversal
    public tree doBTToLinkedList(tree root,tree storeRoot){
        if(null==root)
            return null;

        tree leftTail = doBTToLinkedList(root.left,storeRoot);
        tree rightTail = doBTToLinkedList(root.right,storeRoot);

        if(null!=leftTail){
            leftTail.right = root;
            root.left = null;
        }
        if(null==leftTail && null==storeRoot){
            storeRoot = root;
        }

        return null!=rightTail?rightTail:root;
    }


    //converting BST to linked list, In pre order traversal
    public tree doBTToLinkedListPreOrder(tree root){
        if(null==root)
            return null;

        tree leftTail = doBTToLinkedListPreOrder(root.left);
        tree rightTail = doBTToLinkedListPreOrder(root.right);

        if(null!=leftTail){
            leftTail.right = root.right;
            root.right = root.left;
            root.left = null;
        }


        return null!=rightTail?rightTail:null!=leftTail?leftTail:root;
    }






    public void performAction(tree root){

    }

}

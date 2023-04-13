package javaDev.ds;

import java.util.LinkedList;
import java.util.Queue;

public class bfsOnTreeLevelOrderTraversal {


    private void bfs(tree node){
        Queue<tree> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            int levelBreadth = queue.size();
            for(int i=0;i<levelBreadth;i++){
                tree localNode = queue.remove();
                if(localNode!=null) {
                    System.out.print(localNode.data+" ");
                    queue.add(localNode.right);
                    queue.add(localNode.left);
                }
            }
            System.out.println("\n");

        }
    }



    public void performAction(tree node){
        System.out.println(" bfs");
        bfs(node);

    }
}

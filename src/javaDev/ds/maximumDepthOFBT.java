package javaDev.ds;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class maximumDepthOFBT {


    public int recursion(tree root,tree obj){
        if(null==root)
            return 0;

        int left = recursion(root.left,obj);
        int right = recursion(root.right,obj);

        if(obj.data<1+Math.max(left,right))
            obj.data = 1+Math.max(left,right);

        return 1+Math.max(left,right);
    }


    public int bfs(tree root){
        Queue<tree> stack = new LinkedList<>();
        if(null!=root)
            stack.add(root);
        int res  = 0;
        while(!stack.isEmpty()){

            int curSize = stack.size();
            System.out.println("----"+curSize);
            for(int i=0;i<curSize;i++){
                tree node = stack.remove();
                if(null!=node){
                    stack.add(node.left);
                    stack.add(node.right);
                }
            }
            if(stack.size()>0)
                res++;
        }


        return res;
    }


    public int dfs(tree root){
        Stack<tree> stack = new Stack<>();
        if(null!=root)
            stack.add(root);
        int res  = 0;
        while(!stack.isEmpty()){

            int curSize = stack.size();
            for(int i=0;i<curSize;i++){
                tree node = stack.pop();
                if(node.left!=null)
                    stack.add(node.left);
                if(node.right!=null)
                    stack.add(node.right);

            }
            if(!stack.isEmpty())
                res++;
        }

        return res;
    }

    public int DFS(tree node){
        Stack<stackie> stack = new Stack<>();
        int res = 0;
        if(null!=node)
            stack.add(new stackie(node,1));
        while(!stack.isEmpty()){
            stackie stackEle = stack.pop();
            if(stackEle.level>res)
                res = stackEle.level;
            if(null!=stackEle.node.left)
                stack.add(new stackie(stackEle.node.left,stackEle.level+1));
            if(null!=stackEle.node.right)
                stack.add(new stackie(stackEle.node.right,stackEle.level+1));
        }

        return res;
    }

    class stackie{
        tree node;
        int level;

        public stackie(tree node, int level) {
            this.node = node;
            this.level = level;
        }
    }


}

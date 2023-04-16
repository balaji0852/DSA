package javaDev.ds;

import java.util.List;

public class serializeAndDeserializeTree {

    public void serialize(List<String> data, tree root){
        if(null==root){
            data.add("N");
            return;
        }
        data.add(String.valueOf(root.data));
        serialize(data,root.left);
        serialize(data,root.right);

    }


    public tree deSerialize(List<String> data,tree index){
        if(data.get(index.data)=="N"){
            index.data += 1;
            return null;
        }
        tree Node = new tree();
        Node.data = Integer.parseInt(data.get(index.data));
        index.data +=1;
        Node.left = deSerialize(data,index);
        Node.right = deSerialize(data,index);

        return Node;
    }






    public void performAction(){

    }
}

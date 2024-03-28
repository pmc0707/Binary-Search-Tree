package BST;

public class DeleteNode {
    public static class rootNode{
        int data;
        rootNode leftNode;
        rootNode rightNode;

        public rootNode(int data) {
            this.data = data;
        }
    }
    public static rootNode insert(rootNode root,int value){
        if(root == null){
            root = new rootNode(value);
            return root;
        }
        if(root.data > value){
            root.leftNode = insert(root.leftNode,value);
        }else {
            root.rightNode = insert(root.rightNode,value);
        }
        return root;
    }
    public static void inorder(rootNode root){
        if(root == null){
            return;
        }
        inorder(root.leftNode);
        System.out.print(root.data+" ");
        inorder(root.rightNode);
    }
    public static rootNode delete(rootNode root, int value){
        if(root.data < value) {
            root.rightNode = delete(root.rightNode,value);
        }
        else if(root.data > value) {
            root.leftNode = delete(root.leftNode,value);
        }
        else {
            //case1 - leafNode
            if(root.leftNode == null && root.rightNode == null){
                return null;
            }
            //case2 - singleChild
            if(root.leftNode == null){
                return root.rightNode;
            } else if (root.rightNode == null) {
                return root.leftNode;
            }
            //case3 - bothChildren
            rootNode inOrderSuccessor = findInorderSuccessor(root.rightNode);
            root.data = inOrderSuccessor.data;
            root.rightNode = delete(root.rightNode,inOrderSuccessor.data);
        }
        return root;
    }
    public static rootNode findInorderSuccessor(rootNode root){
        while (root.leftNode!= null) {
            root = root.leftNode;
        }
        return root;
    }
    public static void main(String[] args) {
        int [] value = {4,5,8,9,7};
        rootNode root = null;
        for (int index = 0; index < value.length; index++) {
            root = insert(root,value[index]);
        }
        inorder(root);
        System.out.println();
        root = delete(root,7);
        System.out.println();
        inorder(root);
    }
}

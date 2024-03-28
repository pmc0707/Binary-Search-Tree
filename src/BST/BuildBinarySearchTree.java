package BST;

public class BuildBinarySearchTree {
    static class Node{
        int data;
        Node left;
        Node right;

         Node(int data) {
            this.data = data;
        }
    }
    public static Node insert(Node root,int value){
        if(root== null){
            root = new Node(value);
            return root;
        }

        if(root.data > value){
            root.left = insert(root.left,value);
        }else{
            root.right = insert(root.right,value);
        }
        return root;
    }

    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.println(root.data+" ");
        inorder(root.right);
    }
    public static void main(String[] args) {
        int [] value  = {5,1,2,3,4,6};
        Node root = null;

        for (int index = 0; index < value.length; index++) {
            root = insert(root,value[index]);
        }
        inorder(root);
        System.out.println();
    }
}

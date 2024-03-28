package BST;

public class SearchBinaryTree {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }
    public static Node insert(Node root, int value){
        if(root == null){
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
    public static boolean search(Node root,int key){
        if(root  == null){
            return false;
        }
        if(root.data == key){
            return true;
        }
        if(root.data > key ){
            return search(root.left,key);
        } else {
            return search(root.right,key);
        }
    }
    public static void main(String[] args) {
        int [] value  = {5,1,3,4,2,7};
        Node root = null;

       for (int index = 0; index < value.length; index++) {
            root = insert(root,value[index]);
        }
        if(search(root,5)){
            System.out.println("key is found");
        }else {
            System.out.println("key is not found");
        }
    }
}

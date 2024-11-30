package tree;

public class BST {
    public static class Node {
        private Node left;
        private Node right;
        private int value;
        private int height;

        public Node(int value){
            this.value = value;
        }

        public int getValue(){
            return value;
        }
    }

    private Node root;

    public int height(Node node){
        if(node == null) {
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public void insert(int val){
        root = insert(val, root);
    }

    private Node insert(int val, Node node){
        if(node == null){
            node = new Node(val);
            return node;
        }
        if(node.value > val) node.left = insert(val, node.left);
        if(node.value < val) node.right = insert(val, node.right);
        node.height = Math.max(height(node.left), height(node.right));
        return node;
    }

    public void diplay(){
        display(this.root, "Root Node :");
    }

    private void display(Node node, String details){
        if(node == null) return;
        System.out.println(details + node.value);
        display(node.left, "Left of node "+ node.value + " : ");
        display(node.right, "Right of node "+ node.value + " : ");
    }
}

/*
    Questions:
        1. Minimum possible difference : https://leetcode.com/problems/minimum-distance-between-bst-nodes/description/
        2. Convert sorted array to BST : https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
 */

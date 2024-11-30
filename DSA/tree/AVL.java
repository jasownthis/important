package tree;

public class AVL {
    public class Node{
        private int value;
        private Node left;
        private Node right;
        private int height;

        public Node(int value) { this.value = value; }
        public int getValue() { return this.value; }
    }
    private Node root;
    public int height(){
        return height(root);
    }
    private int height(Node node){
        if(node == null) return -1;
        return node.height;
    }

    public boolean isEmpty() { return root == null;}
    public void insert(int value){
        root = insert(root, value);
    }

    private Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }

        if(root.value > val) root.left = insert(root.left , val);
        if(root.value < val) root.right = insert(root.right, val);
        root.height = Math.max(height(root.left), height(root.right)) + 1;
        return rotate(root);
    }

    private Node rotate(Node node){
        if(height(node.left) - height(node.right) > 1){
            // left heavy
            if(height(node.left.left) - height(node.left.right) > 0){
                // left-left case
                return rightRotate(node);
            }
            if(height(node.left.left) - height(node.left.right) < 0){
                // left - right case
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        if(height(node.left) - height(node.right) < -1){
            // right heavy
            if(height(node.right.left) - height(node.right.right) < 0){
                // right - right case
                return leftRotate(node);
            }
            if(height(node.right.left) - height(node.right.right) > 0){
                // right - left case
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node;
    }

    private Node rightRotate(Node p){
        Node c = p.left;
        Node t = c.right;

        c.left = p;
        p.right = t;

        p.height = Math.max(height(p.left) , height(p.right)  + 1) ;
        c.height = Math.max(height(c.left) , height(c.right) + 1 );
        return c;
    }

    private Node leftRotate(Node c){
        Node p = c.right;
        Node t = p.left;

        p.left = c;
        c.right = t;
        p.height = Math.max(height(p.left) , height(p.right) + 1);
        c.height = Math.max(height(c.left) , height(c.right) + 1);
        return p;
    }

    public void display(){
        display(this.root, "Root node : ");
    }

    private void display(Node root, String details){
        if(root == null) return;
        System.out.println(details + root.value);
        if(root.left != null) display(root.left, "Left node of " + root.value + " : ");
        if(root.right != null) display(root.right, "Right node of " + root.value + " : ");
    }

}

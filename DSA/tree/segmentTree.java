package tree;

public class segmentTree {
    public static class Node{
        private int data;
        private int startingIndex ;
        private int endingIndex;
        private Node left;
        private Node right;

        public Node(int startingIndex, int endingIndex){
            this.startingIndex = startingIndex;
            this.endingIndex = endingIndex;
        }
    }

    private Node root;
    public segmentTree(int[] arr){
        this.root = constructTree(arr, 0, arr.length-1);
    }

    private Node constructTree(int[] arr, int start, int end){
        if(start == end){
            // leaf node
            Node leaf = new Node(start,end);
            leaf.data = arr[start];
            return leaf;
        }

        Node node = new Node(start, end);
        int mid = (start + end) / 2;

        node.left = constructTree(arr, start, mid);
        node.right = constructTree(arr, mid+1, end);
        node.data = node.left.data + node.right.data;
        return node;
    }

    public void display(){
        display(this.root);
    }

    private void display(Node root){
        String str = "";
        if(root.left != null){
           str += "Ineterval =[" + root.left.startingIndex + "," + root.left.endingIndex +"] and data: "+ root.left.data + " => ";
        }
        else{
            str += " no left node available => ";
        }

        str += "Ineterval =[" + root.startingIndex + "," + root.endingIndex +"] and data: "+ root.data + " <= ";

        if(root.right != null){
            str += "Ineterval =[" + root.right.startingIndex + "," + root.right.endingIndex +"] and data: "+ root.right.data ;
        }
        else{
            str += " <= no right node available ";
        }

        System.out.println(str + '\n');

        if(root.left != null) display(root.left);
        if(root.right != null) display(root.right);
    }

    public int query(int qsi, int qei){
        return query(this.root, qsi, qei);
    }

    private int query(Node root, int qsi, int qei){
        if(root.startingIndex >= qsi && root.endingIndex <= qei){
            // interval is completely inside query range
            return root.data;
        }
        else if(root.startingIndex > qei || root.endingIndex < qsi){
            // interval is completely outside the query range
            return 0;
        }
        else {
            return query(root.left, qsi, qei) + query(root.right, qsi, qei);
        }
    }

    public void updateData(int index , int value){
        this.root.data = updateData(this.root, index, value);
    }

    private int updateData(Node root, int index, int value){
        if(index >= root.startingIndex && index <= root.endingIndex){
            if(index == root.startingIndex && index == root.endingIndex){
                root.data = value;
                return root.data;
            }

            int leftValue = updateData(root.left, index, value);
            int rightValue = updateData(root.right, index, value);
            root.data = leftValue + rightValue;
            return root.data;
        }
        return root.data;
    }

}

package tree;
import java.util.*;

public class tree {
    public static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value){
            this.value = value;
        }


    }
    private Node root;

    public void populate(Scanner scanner){
        System.out.println("Enter the value of root node: ");
        int val = scanner.nextInt();
        root = new Node(val);
        populate(scanner, root);
    }

    public void populate(Scanner scanner, Node node){
        // left subtree
        System.out.println("Do you want to add an element to the left of Node " + node.value);
        boolean left = scanner.nextBoolean();
        if(left){
            System.out.println("Enter the value of node left to node "+ node.value);
            int val = scanner.nextInt();
            node.left = new Node(val);
            populate(scanner, node.left);
        }

        // right subtree
        System.out.println("Do you want to add an element to the right of Node "+ node.value);
        boolean right =  scanner.nextBoolean();
        if(right){
            System.out.println("Enter the value of node right to Node "+ node.value);
            int val = scanner.nextInt();
            node.right = new Node(val);
            populate(scanner, node.right);
        }
    }

    public void display(){
        display(this.root, "");
    }

    private void display(Node node, String indent){
        if(node == null){
            return;
        }

        System.out.println(indent + node.value);
        display(node.left , indent + '\t');
        display(node.right, indent + '\t');
    }
}

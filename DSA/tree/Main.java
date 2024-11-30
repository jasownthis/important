package tree;
import java.util.*;
public class Main {
    public static void main(String[] args) {
//        // Binary tree
//        tree t = new tree();
//        Scanner sc = new Scanner(System.in);
//        t.populate(sc);
//        t.display();
//
//        // Binary Search Tree
//        BST bst = new BST();
//        bst.insert(5);
//        bst.insert(2);
//        bst.insert(8);
//        bst.insert(1);
//        bst.insert(3);
//        bst.insert(7);
//        bst.insert(9);
//        bst.diplay();
//
//        // AVL tree
//        AVL avlTree = new AVL();
//        for(int i = 0 ; i < 1000; i++) { avlTree.insert(i); };
//        System.out.println(avlTree.height());

        // Segment tree
        int[] arr = {3, 8, 6, 7, -2, -8, 4, 9};
        segmentTree tree = new segmentTree(arr);
        tree.display();
        System.out.print("Before upadte: ");
        System.out.println(tree.query(1,6));
        tree.updateData(3,8);
        System.out.print("After upadte: ");
        System.out.println(tree.query(1,6));


    }
}

package linkedList;

public class main {
    public static void main(String[] args) {

//        // single linked list
//        single_linkedList SL = new single_linkedList();
//        SL.insertAtFirst(500);
//        SL.insertAtFirst(400);
//        SL.insertAtFirst(300);
//        SL.insertAtFirst(200);
//        SL.insertAtFirst(100);
//        SL.insertAtLast(600);
//        SL.insertAtIndex(150,1);
//        SL.insertAtIndex(275,3);
//        SL.deleteElement(100);
//        SL.display();


        // double linked list
        double_linkedList DLL = new double_linkedList() ;
        DLL.insertAtFirst(500);
        DLL.insertAtFirst(400);
        DLL.insertAtFirst(300);
        DLL.insertAtFirst(200);
        DLL.insertAtFirst(100);
        DLL.insertAfter(150, 100);
        DLL.insertAtLast(600);
        DLL.deleteAtMiddle();
        DLL.display();

//        // circular linked list
//        circular_linkedList CL = new circular_linkedList();
//        CL.insertAtFirst(500);
//        CL.insertAtFirst(400);
//        CL.insertAtFirst(300);
//        CL.insertAtFirst(200);
//        CL.insertAtFirst(100);
//        CL.insertAtLast(600);
//        CL.deleteElement(500);
//        CL.display();
    }
}

/* linked list interview and practice questions

   video link : https://youtu.be/70tx7KcMROc?si=kAmseJ9lkKenog8t
   questions:
        1. Remove duplicates from sorted list : https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
        2. Merge two sorted list : https://leetcode.com/problems/merge-two-sorted-lists/description/
        3. Linked list cycle : https://leetcode.com/problems/linked-list-cycle/description/
        4. Linked list cycle 2 : https://leetcode.com/problems/linked-list-cycle-ii/
        5. Happy Number : https://leetcode.com/problems/happy-number/description/
        6. Middle of Linked list : https://leetcode.com/problems/middle-of-the-linked-list/description/
        7. Sort list : https://leetcode.com/problems/sort-list/description/
        8. Reverse a linked list : https://leetcode.com/problems/reverse-linked-list/description/
        9. Reverse a linked list 2 : https://leetcode.com/problems/reverse-linked-list-ii/description/
        10. Palindromic list : https://leetcode.com/problems/palindrome-linked-list/description/
        11. Reorder list : https://leetcode.com/problems/reorder-list/description/
        12. Reverse Node in k - groups : https://leetcode.com/problems/reverse-nodes-in-k-group/description/
        13. Rotate list : https://leetcode.com/problems/rotate-list/
 */


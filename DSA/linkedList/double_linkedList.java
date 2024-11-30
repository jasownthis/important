package linkedList;

public class double_linkedList {

    private Node head;
    private Node tail;
    private int size;

    public double_linkedList(){
        this.size = 0;
    }

    public void insertAtFirst(int value){
        Node node = new Node(value);
        if(head == null){
            node.prev = null;
            node.next = null;
            head = node;
            size++;
        }
        if(tail == null){
            tail = head;
        }

        node.next = head;
        node.prev = null;
        head.prev = node;
        head = node;
        size++;

    }
    public void insertAfter(int value, int after){
        Node temp = head;
        while(temp.value != after){
            temp = temp.next;
        }
        Node node = new Node(value);
        node.next = temp.next;
        node.prev = temp;
        node.next.prev = node;
        temp.next = node;
    }
    public void insertAtLast(int value){
        if(head == null){
            insertAtFirst(value);
            return;
        }
        else{
            Node node = new Node(value);
            tail.next = node;
            node.prev = tail;
            node.next = null;
            tail = node;
        }
    }

    public void deleteAtMiddle(){
        Node slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.prev.next = slow.next;
        slow.next.prev = slow.prev;
    }
    public void display() {
        Node temp = head;
       while(temp != null){
           System.out.print(temp.value + " -> ");
           temp = temp.next;
       }
        System.out.print("END");
    }

    class Node{
        int value;
        Node next;
        Node prev;

        public Node(int value){
            this.value = value;
        }

        public Node(int value, Node next, Node prev){
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}

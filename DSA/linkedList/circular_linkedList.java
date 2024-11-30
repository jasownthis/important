package linkedList;

public class circular_linkedList {
    private Node head;
    private Node tail;

    public void insertAtFirst(int value){
        Node node = new Node(value);
        if(head == null){
            head = node;
            tail = node;
        }
        node.next = head;
        tail.next = node;
        head = node;
    }
    public void insertAtLast(int value){
        if(tail == null){
            insertAtFirst(value);
            return;
        }
        else{
            Node node = new Node(value);
            tail.next = node;
            node.next = head;
            tail = node;
        }
    }
    public void deleteElement(int value){
        Node node = head;
        if(value == head.value){
            tail.next = head.next;
            head = head.next;
        }
        do{
            if(node.next.value == value){
                node.next = node.next.next;
            }
            node = node.next;
        }while(node != head);
    }
    public void display(){
        if(head == null){
            System.out.println("list is empty");
        }
        Node temp = head;
        do {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }while(temp != head);
        System.out.println("END");
    }
    class Node{
        int value;
        Node next;

        public Node(int value){
            this.value = value;
        }

        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }
}

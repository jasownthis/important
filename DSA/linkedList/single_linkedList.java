package linkedList;

public class single_linkedList {

    private Node head;
    private Node tail;
    private int size;

    public single_linkedList(){
        this.size = 0;
    }

    public void insertAtFirst(int value){
        Node node = new Node(value);
        node.next = head;
        head = node;
        if(tail == null){
            tail = head;
        }
        size++;
    }

    public void insertAtLast(int value){
        if(tail == null){
            insertAtFirst(value);
            return;
        }
        Node node = new Node(value);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insertAtIndex(int value , int index){
        Node temp = head;
        for(int i = 1; i < index; i++){
            temp = temp.next;
        }

        Node node = new Node(value, temp.next);
        temp.next = node;
        size++;
    }

    public void deleteAtLast(){
        Node temp = head;
        while(temp.next != tail){
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
        size--;
    }

    public void deleteAtFirst(){
        head = head.next;
        size--;
    }

    public void deleteElement(int value){
        if(value == tail.value){
            deleteAtLast();
        }
        if(value == head.value){
            deleteAtFirst();
        }
        else{
            Node temp = head;
            while(temp.next.value != value){
                temp = temp.next;
            }
            temp.next = temp.next.next;
            size--;
        }
    }

    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value+ " -> ");
            temp = temp.next;
        }
        System.out.print("END");
        System.out.println();
        System.out.println("size of list : " + size);
    }

    private class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }

        public Node(int value, Node next){
            this.value = value;
            this.next =  next;
        }
    }
}

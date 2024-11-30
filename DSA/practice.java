public class practice {
    class ListNode{
        int value;
        ListNode next;

        public ListNode(int val, ListNode next){
            this.value = val;
            this.next = next;
        }

        public ListNode(){};
    }

    public ListNode mergeSortedList(ListNode l1, ListNode l2){
        ListNode ans = new ListNode();
        ListNode tail = ans;

        while(l1 != null && l2 != null){
            if(l1.value < l2.value){
                tail.next = l1;
                l1 = l1.next;
                tail =tail.next;
            }
            // 1 , 1 || 2, 1

            else{
                tail.next = l2;
                l2 = l2.next;
                tail = tail.next;
            }
        }

        if(l1 != null){
            tail.next = l1.next;
        }
        else{
            tail.next = l2.next;
        }

        return ans.next;
    }
}

package Stack_and_Queue;

import java.util.*;

public class In_Built_stack_and_queue {
    public static void main(String[] args) {

        // <=========== Stack operation ============>
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(9);
        stack.push(19);
        stack.push(3);
        stack.push(34);

        System.out.println("peek element of stack");
        System.out.println(stack.peek());

        System.out.println("poping from stack");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        // <========= End of Stack operation ===========>

        // <============== Queue operation ==============>
        Queue<Integer> queue = new LinkedList<>();
        queue.add(5);
        queue.add(3);
        queue.add(9);
        queue.add(19);
        queue.add(34);

        System.out.println("front element of queue");
        System.out.println(queue.peek());

        System.out.println("poping from queue");
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        // <============ End of Queue operation ===========>

        // <=============== Deque operation ==============>
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(5);
        deque.addFirst(9);
        deque.addLast(19);
        deque.add(3);
        deque.addLast(34);

        System.out.println("peek element of deque");
        System.out.println(deque.getFirst());

        System.out.println("last element of deque");
        System.out.println(deque.getLast());

        System.out.println("poping first element from deque");
        System.out.println(deque.removeFirst());

        System.out.println("poping last element from deque");
        System.out.println(deque.removeLast());

        System.out.println("poping from deque");
        System.out.println(deque.remove());
        System.out.println(deque.remove());
        System.out.println(deque.remove());
        // <============ End of Deque operation ===========>
    }
}

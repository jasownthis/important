package Stack_and_Queue;

public class main_customStack {
    public static void main(String[] args) throws StackException {
        custom_stack stack = new dynamic_customStack(5);
        stack.push(5);
        stack.push(9);
        stack.push(19);
        stack.push(3);
        stack.push(34);
        stack.push(35);

        System.out.println("peek element of stack");
        System.out.println(stack.peek());

        System.out.println("stack element: ");
        stack.display();

        System.out.println("poping from stack");
        System.out.println(stack.pop());
    }
}

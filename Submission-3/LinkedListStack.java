public class LinkedListStack {

    private static class StackNode {
        private final int value;
        private StackNode link;

        StackNode(int value) {
            this.value = value;
        }
    }

    private StackNode head;

    public void push(int value) {
        StackNode node = new StackNode(value);
        node.link = head;
        head = node;
    }

    public int pop() {
        if (head == null) {
            throw new IllegalStateException("Cannot pop from an empty stack");
        }
        int result = head.value;
        head = head.link;
        return result;
    }

    public int peek() {
        if (head == null) {
            throw new IllegalStateException("Cannot peek an empty stack");
        }
        return head.value;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void display() {
        StackNode cursor = head;
        while (cursor != null) {
            System.out.println(cursor.value);
            cursor = cursor.link;
        }
    }

    public static void main(String[] args) {
        LinkedListStack st = new LinkedListStack();

        st.push(10);
        st.push(20);
        st.push(30);

        st.display();

        System.out.println("Top: " + st.peek());
        System.out.println("Removed: " + st.pop());

        st.display();
    }
}
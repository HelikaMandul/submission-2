public class LinkedListFIFOQueue {

    private static class QueueNode {
        private final int value;
        private QueueNode link;

        QueueNode(int value) {
            this.value = value;
        }
    }

    private QueueNode head;
    private QueueNode tail;

    public void enqueue(int value) {
        QueueNode node = new QueueNode(value);
        if (tail == null) {
            head = tail = node;
        } else {
            tail.link = node;
            tail = node;
        }
    }

    public int dequeue() {
        if (head == null) {
            throw new IllegalStateException("Cannot dequeue from an empty queue");
        }
        int result = head.value;
        head = head.link;
        if (head == null) {
            tail = null;
        }
        return result;
    }

    public int peek() {
        if (head == null) {
            throw new IllegalStateException("Cannot peek an empty queue");
        }
        return head.value;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void display() {
        QueueNode cursor = head;
        while (cursor != null) {
            System.out.print(cursor.value + " -> ");
            cursor = cursor.link;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedListFIFOQueue q = new LinkedListFIFOQueue();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        q.display();

        System.out.println("Front: " + q.peek());
        System.out.println("Removed: " + q.dequeue());

        q.display();
    }
}
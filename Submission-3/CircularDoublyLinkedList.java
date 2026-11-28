public class CircularDoublyLinkedList {

    private static class LinkNode {
        int value;
        LinkNode forward;
        LinkNode backward;

        LinkNode(int value) {
            this.value = value;
        }
    }

    private LinkNode first;
    private LinkNode last;

    public void insertFirst(int value) {
        LinkNode node = new LinkNode(value);

        if (first == null) {
            first = last = node;
            node.forward = node;
            node.backward = node;
            return;
        }

        node.forward = first;
        node.backward = last;
        last.forward = node;
        first.backward = node;
        first = node;
    }

    public void insertLast(int value) {
        LinkNode node = new LinkNode(value);

        if (first == null) {
            first = last = node;
            node.forward = node;
            node.backward = node;
            return;
        }

        node.forward = first;
        node.backward = last;
        last.forward = node;
        first.backward = node;
        last = node;
    }

    public void insertAtPosition(int value, int pos) {
        if (pos < 1) {
            return;
        }
        if (pos == 1) {
            insertFirst(value);
            return;
        }
        if (first == null) {
            return;
        }

        LinkNode cursor = first;
        for (int i = 1; i < pos - 1; i++) {
            if (cursor == last) {
                return;
            }
            cursor = cursor.forward;
        }

        if (cursor == last) {
            insertLast(value);
            return;
        }

        LinkNode node = new LinkNode(value);
        node.forward = cursor.forward;
        node.backward = cursor;
        cursor.forward.backward = node;
        cursor.forward = node;
    }

    public void insertAfter(int value, int key) {
        if (first == null) {
            return;
        }

        LinkNode cursor = first;
        while (cursor.value != key) {
            cursor = cursor.forward;
            if (cursor == first) {
                return;
            }
        }

        if (cursor == last) {
            insertLast(value);
            return;
        }

        LinkNode node = new LinkNode(value);
        node.forward = cursor.forward;
        node.backward = cursor;
        cursor.forward.backward = node;
        cursor.forward = node;
    }

    public void insertBefore(int value, int key) {
        if (first == null) {
            return;
        }

        LinkNode cursor = first;
        while (cursor.value != key) {
            cursor = cursor.forward;
            if (cursor == first) {
                return;
            }
        }

        if (cursor == first) {
            insertFirst(value);
            return;
        }

        LinkNode node = new LinkNode(value);
        node.forward = cursor;
        node.backward = cursor.backward;
        cursor.backward.forward = node;
        cursor.backward = node;
    }

    public void deleteLast() {
        if (first == null) {
            return;
        }
        if (first == last) {
            first = last = null;
            return;
        }

        last = last.backward;
        last.forward = first;
        first.backward = last;
    }

    public void deleteAtPosition(int pos) {
        if (first == null || pos < 1) {
            return;
        }

        LinkNode cursor = first;
        for (int i = 1; i < pos; i++) {
            if (cursor == last) {
                return;
            }
            cursor = cursor.forward;
        }

        if (cursor == last) {
            deleteLast();
            return;
        }

        if (cursor == first) {
            first = first.forward;
            first.backward = last;
            last.forward = first;
            return;
        }

        cursor.backward.forward = cursor.forward;
        cursor.forward.backward = cursor.backward;
    }

    public static void main(String[] args) {
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();

        list.insertFirst(20);
        list.insertFirst(10);
        list.insertLast(40);
        list.insertAtPosition(30, 3);
        list.insertAfter(35, 30);
        list.insertBefore(15, 20);
        list.deleteLast();
        list.deleteAtPosition(2);
    }
}
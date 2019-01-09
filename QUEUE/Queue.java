public class Queue<T> {
    private Node head;
    private Node tail;

    public Queue() {
        head = new Node(null , null);
        tail = head;
    }

    public boolean isEmpty() {
        if(head == tail) {
            return true;
        }
        return false;
    }

    public void enqueue(T value) {

        tail.value = value;
        tail.next = new Node(null , null);
        tail = tail.next;

    }

    public void dequeue() {
        if(isEmpty()) {
            return;
        }
        head = head.next;
    }

    public T getHead() {
        if(isEmpty()) {
            return null;
        }
        return (T) head.value;
    }
    
}

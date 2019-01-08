import java.util.ArrayList;
import java.util.List;

public class Queue<T> {
    private int head = 0;
    private int tail = 0;
    List<T> queue;

    public Queue() {
        queue = new ArrayList<>();
    }

    public boolean isEmpty() {
        if(head == tail) {
            return true;
        }
        return false;
    }

    public void enqueue(T value) {
        queue.add(value);
        tail++;
    }

    public void dequeue() {
        head++;
    }

    public T getHead() {
        return queue.get(head);
    }


}

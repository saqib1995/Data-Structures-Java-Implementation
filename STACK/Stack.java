import java.util.ArrayList;
import java.util.List;

public class Stack<T> {
    private final List<T> stack;

    public Stack() {
        stack = new ArrayList();
    }

    public void push(T value) {
        stack.add(value);
    }

    public T pop() {
        T answer;
        if(stack.isEmpty()) {
            return null;
        }
        answer = stack.remove(stack.size() - 1);
        return answer;
    }

    public T peek() {
        if(stack.isEmpty()) {
            return null;
        }
        return stack.get(stack.size() - 1);
    }

}

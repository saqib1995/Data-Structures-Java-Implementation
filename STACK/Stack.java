import java.util.ArrayList;
import java.util.List;

public class Stack<T> {
    private int top = -1;
    private final List<T> stack;

    public Stack() {
        stack = new ArrayList();
    }

    public boolean empty() {
        if(top == -1) {
            return true;
        }
        return false;
    }

    public void push(T value) {
        top++;
        stack.add(value);
    }

    public T pop() {
        T answer;
        if(empty()) {
            return null;
        }
        answer = stack.get(top);
        top--;
        return answer;
    }

    public T peek() {
        if(empty()) {
            return null;
        }
        return stack.get(top);
    }


}

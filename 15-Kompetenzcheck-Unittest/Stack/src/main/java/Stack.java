public class Stack {
    DoubleLinkedList<Integer> stack = new DoubleLinkedList<>();

    void push(int newElement) {
        stack.add(newElement);
    }

    public int size() {
        return stack.size();
    }

    public int pop() {
        if (stack.size() == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        int temp = stack.get(stack.size());
        stack.remove(stack.size());
        return temp;
    }

    public int peek() {
        if (stack.size() == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return stack.get(stack.size() + 1);
    }

    public void pop(int howMany) {
        for (int i = 0; i < howMany; i++) {
            System.out.println(stack.get(stack.size()));
            stack.remove(stack.size());
        }
    }

    public void print() {
        for (int i = 0; i < stack.size(); i++) {
            System.out.println(stack.toString());
        }
    }
}

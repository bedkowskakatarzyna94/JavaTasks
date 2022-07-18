package stacks_and_queues;

class Stack {
    private final int maxStackSize;
    private final long[] stackArray;
    private int top;

    public Stack(int s) {
        maxStackSize = s;
        stackArray = new long[maxStackSize];
        top = -1;
    }
    public void push(long newElement) {
        stackArray[++top] = newElement;
    }
    public long pop(){
        return stackArray[top--];
    }
    public long peek(){
        return stackArray[top];
    }
    public boolean isEmpty(){
        return (top == -1);
    }
    public boolean isFull(){
        return (top == maxStackSize -1);
    }
}
class StackApp {
    public static void main(String[] args) {
        Stack theStack = new Stack(10);
        theStack.push(20);
        theStack.push(40);
        theStack.push(60);
        theStack.push(80);

        theStack.peek();
        theStack.isFull();

        while (!theStack.isEmpty()) {
            long value = theStack.pop();
            System.out.print(value);
            System.out.print(" ");
        }
        System.out.println(" ");
    }
}
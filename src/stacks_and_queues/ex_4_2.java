package stacks_and_queues;

class Deque {
    static final int maxDequeSize = 100;
    int[] dequeArray;
    int front;
    int rear;
    int dequeSize;

    public Deque(int size) {
        dequeArray = new int[maxDequeSize];
        front = -1;
        rear = 0;
        this.dequeSize = size;
    }

    public boolean isEmpty() {
        return (front == -1);
    }

    public boolean isFull() {
        return ((front == 0 && rear == dequeSize - 1) ||
                front == rear + 1);
    }

    void insertRight(int key) {
        if (isFull()) {
            System.out.println("stacks_and_queues.Deque is full");
            return;
        }
        if (front == -1) {
            front = 0;
            rear = 0;
        } else if (front == 0)
            front = dequeSize - 1;
        else front = front - 1;
        dequeArray[front] = key;
    }

    void insertLeft(int key) {
        if (isFull()) {
            System.out.println("stacks_and_queues.Deque is full");
            return;
        }
        if (front == -1) {
            front = 0;
            rear = 0;
        } else if (rear == dequeSize - 1)
            rear = 0;
        else rear = rear + 1;
        dequeArray[rear] = key;
    }

    void deleteRight() {
        if (isEmpty()) {
            System.out.println("stacks_and_queues.Deque is empty");
            return;
        }
        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (front == dequeSize - 1)
            front = 0;
        else front = front + 1;
    }

    void deleteLeft() {
        if (isEmpty()) {
            System.out.println("stacks_and_queues.Deque is empty");
            return;
        }
        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (rear == 0)
            rear = dequeSize - 1;
        else
            rear = rear - 1;
    }

    public static void main(String[] args) {

        Deque theDeque = new Deque(5);


        theDeque.insertLeft(5);
        theDeque.insertLeft(1);
        theDeque.insertRight(15);
        theDeque.insertRight(2);

        theDeque.deleteLeft();
        theDeque.deleteRight();

        theDeque.insertRight(3);
        theDeque.insertLeft(4);

        theDeque.deleteRight();

    }
}

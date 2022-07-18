package stacks_and_queues;

class Queue {
    private final int maxQueueSize;
    private final long[] queArray;
    private int front;
    private int rear;
    private int numberOfItems;

    public Queue(int queueSize) {
        maxQueueSize = queueSize;
        queArray = new long[maxQueueSize];
        front = 0;
        rear = -1;
        numberOfItems = 0;
    }

    public void insert(long j) {
        if (rear == maxQueueSize - 1)
            rear = -1;
        queArray[++rear] = j;
        numberOfItems++;
    }

    public long remove() {
        long temp = queArray[front++];
        if (front == maxQueueSize)
            front = 0;
        numberOfItems--;
        return temp;
    }

    public long peekFront() {
        return queArray[front];
    }

    public boolean isEmpty() {
        return (numberOfItems == 0);
    }

    public boolean isFull() {
        return (numberOfItems == maxQueueSize);
    }

    public int size() {
        return numberOfItems;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is Empty!");
        }
        for (int i = front; i < maxQueueSize; i++) {
            System.out.println(queArray[i]);
        }
        if (rear < front && rear >= 0) {
            for (int i = rear; i < front; i++) {
                System.out.println(queArray[rear]);
            }
        }
    }
}

class QueueApp {
    public static void main(String[] args) {
        Queue theQueue = new Queue(5);

        theQueue.insert(10);
        theQueue.insert(20);
        theQueue.insert(30);
        theQueue.insert(40);
        theQueue.remove();
        theQueue.remove();
        theQueue.insert(50);

        theQueue.display();
        theQueue.remove();
        theQueue.remove();

        theQueue.insert(50);
        theQueue.insert(60);
        theQueue.insert(70);
        theQueue.insert(80);


        while (!theQueue.isEmpty()) {
            long n = theQueue.remove();
            System.out.print(n);
            System.out.print(" ");
        }

    }
}

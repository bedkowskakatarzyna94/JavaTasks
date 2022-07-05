class ArrayBub {
    private long[] a;
    private int nElems;

    public ArrayBub(int max) {
        a = new long[max];
        nElems = 0;
    }

    public void insert(long value) {
        a[nElems] = value;
        nElems++;
    }

    public void display() {
        for (int j = 0; j < nElems; j++)
            System.out.print(a[j] + " ");
        System.out.println("");
    }

    public void bubbleSort() {
        int out, in;

        for (out = nElems - 1; out > 1; out--)
            for (in = 0; in < out; in++)
                if (a[in] > a[in + 1])
                    swap(in, in + 1);
    }

    //ex.3.1
    public void inverseBubbleSort() {
        int out, in;
        for (out = 0; out < nElems - 1; out++)
            for (in = nElems - 1; in > out; in--)
                if (a[in] < a[in - 1])
                    swap(in, in - 1);
    }

    //ex.3.4
    public void oddEvenSort() {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            long temp = 0;
            for (int i = 1; i <= nElems - 2; i = i + 2) {
                if (a[i] > a[i + 1]) {
                    swap(i, i + 1);
                    isSorted = false;
                }
            }

            for (int i = 0; i <= nElems - 2; i = i + 2) {
                if (a[i] > a[i + 1]) {
                    swap(i, i + 1);
                    isSorted = false;
                }
            }
        }
    }

    private void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
}

class BubbleSortApp {
    public static void main(String[] args) {
        int maxSize = 100;
        ArrayBub arr;
        arr = new ArrayBub(maxSize);

        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);

        System.out.print("Array: ");
        arr.display();
        arr.inverseBubbleSort();
        System.out.print("Inverse Bubble Sort: ");
        arr.display();
        arr.bubbleSort();
        System.out.print("Bubble Sort: ");
        arr.display();
        arr.oddEvenSort();
        System.out.print("Odd Even Sort: ");
        arr.display();
    }
}

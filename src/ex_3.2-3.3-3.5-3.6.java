class ArrayIns {
    private long[] a;
    private int nElems;

    public ArrayIns(int max) {
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

    //ex.3.5, ex.3.6
    public void insertionSort() {
        int in, out;
        int copies = 0;
        int comparisons = 0;
        for (out = 1; out < nElems; out++) {
            long temp = a[out];
            in = out;
            while (in > 0 && a[in - 1] >= temp) {
                if (temp == a[in - 1])
                    temp = -1;
                comparisons += 1;
                a[in] = a[in - 1];
                copies += 1;
                --in;
            }
            a[in] = temp;
            copies += 1;
        }

        System.out.println("copies: " + copies + " comparisons: " + comparisons);
    }

    //ex.3.2
    public double median() {
        double median_value;
        //insertionSort();
        if (nElems % 2 == 0) {
            median_value = (double) (a[nElems / 2] + a[(nElems / 2) - 1]) / 2;
        } else {
            median_value = (double) a[nElems / 2];
        }
        return median_value;
    }

    //ex.3.3
    public void noDups() {
        int i = 0;
        for (int j = 1; j < nElems; j++) {
            if (a[i] != a[j]) {
                i++;
                a[i] = a[j];
            }
        }
    }
}

class InsertSortApp {
    public static void main(String[] args) {
        int maxSize = 100;
        ArrayIns arr;
        arr = new ArrayIns(maxSize);

        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(33);
        arr.insert(22);
        arr.insert(88);
        arr.insert(55);
        arr.insert(33);
        arr.insert(11);
        arr.insert(55);
        arr.insert(66);
        arr.insert(33);

        System.out.print("Array: ");
        arr.display();
        arr.insertionSort();
        System.out.print("Insertion Sort without duplicates: ");
        arr.display();
        System.out.print("Median: ");
        System.out.println(arr.median());
        arr.noDups();
        System.out.print("No duplicates: ");
        arr.display();
    }
}
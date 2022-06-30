class HighArray {
    private long[] a;
    private int nElems;

    public HighArray(int max) {
        a = new long[max];
        nElems = 0;
    }

    public boolean find(long searchKey) {
        int j;
        for (j = 0; j < nElems; j++)
            if (a[j] == searchKey)
                break;
        if (j == nElems)
            return false;
        else
            return true;
    }

    public void insert(long value) {
        a[nElems] = value;
        nElems++;
    }

    public boolean delete(long value) {
        int j;
        for (j = 0; j < nElems; j++)
            if (value == a[j])
                break;
        if (j == nElems)
            return false;
        else {
            for (int k = j; k < nElems; k++)
                a[k] = a[k + 1];
            nElems--;
            return true;
        }
    }

    public void display() {
        for (int j = 0; j < nElems; j++)
            System.out.print(a[j] + " ");
        System.out.println("");
    }

    public long getMax() {
        long max = a[0];
        if (nElems == 0)
            return -1;
        else {
            for (int j = 1; j < nElems; j++) {
                if (a[j] > max)
                    max = a[j];
            }
        }
        return max;
    }

    public long removeMax() {
        long max = getMax();
        delete(max);
        return max;
    }

    public void noDups() {
        for (int i = 0; i < nElems; i++) {
            for (int j = i + 1; j < nElems; j++) {
                if (a[i] == a[j]) {
                    delete(a[i]);
                    j--;
                }
            }
        }
    }
}

class HighArrayApp {
    public static void main(String[] args) {

        int maxSize = 100;

        HighArray arr;
        HighArray sortedArr;

        arr = new HighArray(maxSize);
        sortedArr = new HighArray(maxSize);

        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(33);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(44);
        arr.insert(77);
        arr.insert(35);

        System.out.print("Array: " );
        arr.display();
        System.out.println("Max value: " + arr.getMax());
        arr.noDups();
        System.out.print("Array after removing duplicates: ");
        arr.display();
        arr.removeMax();
        System.out.print("Array after removing max element: ");
        arr.display();

        int searchKey = 35;
        if (arr.find(searchKey))
            System.out.println("Found " + searchKey);
        else
            System.out.println("Can’t find " + searchKey);

        arr.delete(35);
        arr.delete(55);
        arr.delete(99);

        System.out.print("Array after removing some elements: ");
        arr.display();

        for (int i = 0; i < maxSize; i++) {
            long max = arr.removeMax();
            if (max == -1)
                break;
            sortedArr.insert(max);
        }
        System.out.print("Array after sorting: ");
        sortedArr.display();
    }
}


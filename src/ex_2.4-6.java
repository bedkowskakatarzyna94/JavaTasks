class OrdArray {
    private long[] a;
    private int nElems;

    public OrdArray(int max) {
        a = new long[max];
        nElems = 0;
    }

    public int size() {
        return nElems;
    }

    public int find(long searchKey) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;

        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            if (a[curIn] == searchKey)
                return curIn;
            else if (lowerBound > upperBound)
                return nElems;
            else {
                if (a[curIn] < searchKey)
                    lowerBound = curIn + 1;
                else
                    upperBound = curIn - 1;
            }
        }
    }

    public void insert(long value) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn = 0;
        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            if (a[curIn] > value)
                upperBound = curIn - 1;
            else
                lowerBound = curIn + 1;

            if (upperBound < lowerBound) {
                curIn = lowerBound;
                break;
            }
        }
        for (int k = nElems; k > curIn; k--)
            a[k] = a[k - 1];
        a[curIn] = value;
        nElems++;
    }

    public boolean delete(long value) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;

        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            if (a[curIn] == value) {
                for (int k = curIn; k < nElems; k++)
                    a[k] = a[k + 1];
                nElems--;
                return true;
            } else if (lowerBound > upperBound)
                return false;
            else {
                if (a[curIn] < value)
                    lowerBound = curIn + 1;
                else
                    upperBound = curIn - 1;
            }
        }
    }

    public void display() {
        for (int j = 0; j < nElems; j++)
            System.out.print(a[j] + " ");
        System.out.println("");
    }

    public OrdArray merge(OrdArray inputArray) {

        OrdArray mergedArr = new OrdArray(this.size() + inputArray.size());
        int thisIndex = 0;
        int inputIndex = 0;
        int targetIndex = 0;

        while (thisIndex < this.size() && inputIndex < inputArray.size()) {
            if (this.a[thisIndex] > inputArray.a[inputIndex]) {
                mergedArr.a[targetIndex] = inputArray.a[inputIndex];
                inputIndex++;
            } else {
                mergedArr.a[targetIndex] = this.a[thisIndex];
                thisIndex++;
            }
            targetIndex++;
        }
        if (thisIndex == this.size()) {
            while (inputIndex < inputArray.size()) {
                mergedArr.a[targetIndex] = inputArray.a[inputIndex];
                inputIndex++;
                targetIndex++;
            }
        } else {
            while (thisIndex < this.size()) {
                mergedArr.a[targetIndex] = this.a[thisIndex];
                thisIndex++;
                targetIndex++;
            }
        }
        mergedArr.nElems = targetIndex;
        return mergedArr;
    }
}

class OrderedApp {
    public static void main(String[] args) {

        int maxSize = 100;
        OrdArray arr;
        arr = new OrdArray(maxSize);

        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(44);
        arr.insert(66);
        arr.insert(33);

        int searchKey = 55;
        if (arr.find(searchKey) != arr.size())
            System.out.println("Found " + searchKey);
        else
            System.out.println("Can’t find " + searchKey);

        System.out.print("Array: ");
        arr.display();

        arr.delete(44);
        arr.delete(55);
        arr.delete(99);

        System.out.print("Array after deleting some elements: ");
        arr.display();

        arr.insert(34);
        System.out.print("Array after inserting element: ");
        arr.display();

        arr.delete(34);
        System.out.print("Array after deleting element: ");
        arr.display();


        int maxSize1 = 10, maxSize2 = 5, maxValue = 100;
        OrdArray arr1, arr2, arr3;
        arr1 = new OrdArray(maxSize1);
        arr2 = new OrdArray(maxSize2);
        arr3 = new OrdArray(maxSize2);

        for (int j = 0; j < maxSize1; j++)
        {
            long n = (long) (java.lang.Math.random() * (maxValue - 1));
            arr1.insert(n);
        }

        for (int j = 0; j < maxSize2; j++)
        {
            long n = (long) (java.lang.Math.random() * (maxValue - 1));
            arr2.insert(n);
        }

        System.out.print("First array to merge: ");
        arr1.display();
        System.out.print("Second array to merge: ");
        arr2.display();

        arr3 = arr1.merge(arr2);
        System.out.print("Merged array: ");
        arr3.display();
    }
}
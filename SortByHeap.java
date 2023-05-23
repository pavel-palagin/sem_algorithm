public class SortByHeap {
    public static void main(String[] args) {
        int N = 1000;
        int[] array = new int[N];


        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * N);
        }

//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i] + " ");
//
//        }
//        System.out.println();

        long start = System.nanoTime();
        prepareHeap(array);
        System.out.println("Время на сортировку кучей" + " - " + (System.nanoTime() - start));

//        System.out.println();
//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i] + " ");
//
//        }

    }

    public static void prepareHeap(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heap(arr, arr.length, i);
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heap(arr, i, 0);
        }

    }

    public static void heap(int[] arr, int size, int i) {
        int parent = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        if (leftChild < size && arr[leftChild] > arr[parent]) parent = leftChild;
        if (rightChild < size && arr[rightChild] > arr[parent]) parent = rightChild;
        if (parent != i) {
            int temp = arr[i];
            arr[i] = arr[parent];
            arr[parent] = temp;
            heap(arr, size, parent);
        }

    }

}

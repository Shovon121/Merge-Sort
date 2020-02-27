package sample;


public class Main {
    public static void main(String[] args) {
        int array[] = {75, 20, 3, 42, 5, 2, 7, 80, 22};
        System.out.print("UnSorted Array =>");
        printArray(array);

        System.out.println();
         array=margeSort(array);
        System.out.print("Sorted Array =>");
        printArray(array);


    }

    private static void printArray(int array[]) {
        int count=0;
        int stop=array.length-1;
        System.out.print("[");
        for (int i=0;i<array.length;i++){
            if(i==count){
                if(count==stop){
                    System.out.print(array[i]);

                }else {
                    System.out.print(array[i]+",");
                }
                count++;

            }

        }
        System.out.print("]");


    }

    private static int[] margeSort(int array[]) {
        if (array.length <= 1) {
            return array;
        }
        //left size....
        int midpoint = array.length / 2;
        int left[] = new int[midpoint];
        // right size.......
        int right[];
        if (array.length % 2 == 0) {
            right = new int[midpoint];
        } else {
            right = new int[midpoint + 1];
        }
        // Left implementation....

        for (int l = 0; l < midpoint; l++) {
            left[l] = array[l];
        }
        // Right implementation....
        for (int r = 0; r < right.length; r++) {
            right[r] = array[midpoint + r];
        }

        int result[] = new int[array.length];

        // Marge sort recursion......
        left = margeSort(left);

        right = margeSort(right);


        result = marge(left, right);

        return result;


    }

    private static int[] marge(int[] left, int[] right) {
        int leftPointer = 0, rightPointer = 0, resultPointer = 0;
        int result[] = new int[left.length + right.length];

        while (leftPointer < left.length || rightPointer < right.length) {
            if (leftPointer < left.length && rightPointer < right.length) {
                if (left[leftPointer] < right[rightPointer]) {

                    result[resultPointer++] = left[leftPointer++];

                } else {
                    result[resultPointer++]=right[rightPointer++];
                }
            }else if(leftPointer<left.length){
                result[resultPointer++] = left[leftPointer++];
            }else if(rightPointer<right.length){
                result[resultPointer++]=right[rightPointer++];
            }


        }

        return result;
    }
}

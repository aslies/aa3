import java.util.Random;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[1000];
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(100) + 1;
        }

        System.out.println("Sıralanmadan önce");
        printArray(arr);
        mergeSortAsc(arr);
        System.out.println("Küçükten büyüğe: ");
        printArray(arr);
        mergeSortDesc(arr);
        System.out.println("Büyükten küçüğe: ");
        printArray(arr);

    }

    public static void mergeSortAsc(int[] inputArr) {

        if (inputArr.length < 2)
            return;

        int length = inputArr.length;
        int[] leftArr = new int[length / 2];
        int[] rightArr = new int[length - leftArr.length];

        for (int i = 0; i < leftArr.length; i++) {
            leftArr[i] = inputArr[i];
        }

        for (int i = leftArr.length; i < length; i++) {
            rightArr[i-leftArr.length] = inputArr[i];
        }

        mergeSortAsc(leftArr);
        mergeSortAsc(rightArr);

        mergeAsc(inputArr, leftArr, rightArr);
    }

    public static void mergeAsc(int[] inputArr, int[] leftArr, int[] rightArr) {
        int l= 0, r = 0, i = 0;

        while (l < leftArr.length && r < rightArr.length) {
            if (leftArr[l] <= rightArr[r]) {
                inputArr[i] = leftArr[l];
                l++;
            } else {
                inputArr[i] = rightArr[r];
                r++;
            }
            i++;
        }

            while (l < leftArr.length) {
                inputArr[i] = leftArr[l];
                l++;
                i++;
            }

            while (r < rightArr.length) {
                inputArr[i] = rightArr[r];
                r++;
                i++;
            }

    }

    public static void mergeSortDesc(int[] inputArr) {

        if (inputArr.length < 2)
            return;

        int length = inputArr.length;
        int[] leftArr = new int[length / 2];
        int[] rightArr = new int[length - leftArr.length];

        for (int i = 0; i < leftArr.length; i++) {
            leftArr[i] = inputArr[i];
        }

        for (int i = leftArr.length; i < length; i++) {
            rightArr[i-leftArr.length] = inputArr[i];
        }

        mergeSortDesc(leftArr);
        mergeSortDesc(rightArr);

        mergeDesc(inputArr, leftArr, rightArr);
    }

    public static void mergeDesc(int[] inputArr, int[] leftArr, int[] rightArr) {
        int l= 0, r = 0, i = 0;

        while (l < leftArr.length && r < rightArr.length) {
            if (leftArr[l] >= rightArr[r]) {
                inputArr[i] = leftArr[l];
                l++;
            } else {
                inputArr[i] = rightArr[r];
                r++;
            }
            i++;
        }

        while (l < leftArr.length) {
            inputArr[i] = leftArr[l];
            l++;
            i++;
        }

        while (r < rightArr.length) {
            inputArr[i] = rightArr[r];
            r++;
            i++;
        }

    }
    public static void printArray(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
}

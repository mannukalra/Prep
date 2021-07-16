package prep.eop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Java program for implementation of QuickSort
class QuickSort {
    /* This function takes last element as pivot,
       places the pivot element at its correct
       position in sorted array, and places all
       smaller (smaller than pivot) to left of
       pivot and all greater elements to right
       of pivot */
    int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        System.out.println("pivot "+ pivot+" low "+low+" high "+high);
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot)
            {
                i++;
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            System.out.print(Arrays.toString(arr));
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        System.out.println(Arrays.toString(arr)+" piv "+(i+1));
        return i+1;
    }


    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    void sort(int arr[], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    // Driver program
    public static void main(String args[])
    {
//        int arr[] = {12,4,5,16,9,21,2,11};
//        int n = arr.length;
//
//        QuickSort ob = new QuickSort();
//        ob.sort(arr, 0, n-1);
//
//        System.out.println("sorted array");
//        printArray(arr);
        var ints = new ArrayList<>(List.of(0,1,2,3,4));
        ints.set(0, 12);
        ints.add(0, 11);
        System.out.println(ints);
    }
}
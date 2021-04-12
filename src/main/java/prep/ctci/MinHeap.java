package prep.ctci;

import java.util.Arrays;

public class MinHeap {
    private int capacity = 10;
    private int size = 0;
    private int[] items = new int[capacity];

    private boolean hasParent(int index){return (index-1)/2 >= 0;}
    private boolean hasLeftChild(int index){return index*2+1 < size;}
    private boolean hasRightChild(int index){return index*2+2 < size;}

    private int getParentIndex(int index){return (index-1)/2;}
    private int getLeftChildIndex(int index){return index*2+1;}
    private int getRightChildIndex(int index){return index*2+2;}

    private int getParent(int index){return items[(index-1)/2];}
    private int getLeftChild(int index){return items[index*2+1];}
    private int getRightChild(int index){return items[index*2+2];}

    private void ensureCapacity(){
        if(size == capacity){
            items = Arrays.copyOf(items, capacity*2);
            capacity *= 2;
        }
    }
    private void swap(int i, int j){
        int temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }
    int peak(){
        if(size == 0) throw new IllegalStateException();
        return items[0];
    }

    int poll() {
        if (size == 0) throw new IllegalStateException();
        int result = items[0];
        items[0] = items[size - 1];
        size--;
        heapifyDown();
        return result;
    }
    void add(int item){
        ensureCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

    private void heapifyUp(){
        int index = size-1;
        while(hasParent(index) && getParent(index) > items[index]){
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }
    private void heapifyDown(){
        int index = 0;
        while (hasLeftChild(index)){
            int smallerIndex = getLeftChildIndex(index);
            if(hasRightChild(index) && getRightChild(index) < getLeftChild(index)){
                smallerIndex = getRightChildIndex(index);
            }
            if(items[index] > items[smallerIndex])
                swap(index, smallerIndex);
            else
                break;

            index = smallerIndex;
        }
    }

    void print(){
        for(int i=0; i<size; i++)
            System.out.print(items[i]+" ");
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 3, 5, 22, 44};
        int[] arr2 = new int[]{4,15, 23, 52,61};
        int[] arr3 = new int[]{13,25,31,35,42};

        MinHeap heap = new MinHeap();
        for(int i=0; i<arr1.length; i++)
            heap.add(arr1[i]);
        for(int i=0; i<arr2.length; i++)
            heap.add(arr2[i]);
        for(int i=0; i<arr3.length; i++)
            heap.add(arr3[i]);

        heap.print();
        System.out.println();
        while (true)
            System.out.print(heap.poll()+" ");
    }

}

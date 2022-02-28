package de.teleran;

import javax.imageio.stream.ImageInputStream;

public class HeapService {
    int[] heap;
    int size;
    int lastPosition;

    public HeapService(int[] array) {
        heap = array;
        this.size = array.length;
        lastPosition = array.length - 1;
    }



    /**
     * Делает массив таким образом, что тот становится кучей
     *
     * @param array
     */
    // Если у узла в куче индекс в массиве равняется i, то индекс его детей в массиве равняется: 2*i + 1, 2*i + 2
    public void makeHeap(int[] array) {
        for(int i = (int)Math.floor((size-1)/2); i >= 0; i--) {
            siftDown(i, array);
        }
    }

    /**
     * Сдвигает элемент с индексом i вниз по куче таким образом, что он встает на свое место (родитель больше него,
     * а оба дочерних элемента меньше)
     *
     * @param i
     * @param array
     */
    private void siftDown(int i, int[] array) {
        int leftChild = 2*i + 1;
        int rightChild = 2*i + 2;
        int largerChild;
        if(rightChild < size && array[rightChild] > array[leftChild]) {
            largerChild = rightChild;
        } else {
            largerChild = leftChild;
        }
        if(largerChild < size && array[largerChild] > array[i]) {
            int temp = array[i];
            array[i] = array[largerChild];
            array[largerChild] = temp;
            siftDown(largerChild, array);
        }

    }

    public int findMax() {
        if(size > 0) {
            return heap[0];
        } else {
            return -1;
        }
    }


    public int extractMax() {
        int max = heap[0];
        delete(0);
        return max;
    }


    public void insert(int x) {
        heap[lastPosition] = x;
        siftUp(heap, lastPosition);
        lastPosition++;
    }


    public void delete(int i) {
        heap[i] = heap[lastPosition];
        lastPosition--;
        size--;

        siftUp(heap, i);
        siftDown(i, heap);
    }


    public void siftUp(int[] array, int i) {
        int parent = (int)Math.floor((i-1)/2);
        if(i > 0 && array[parent] < array[i]) {
            int temp = array[i];
            array[i] = array[parent];
            array[parent] = temp;
            siftUp(array, parent);
        }
    }



    public int[] heapSort() {
        makeHeap(heap);
        for(int i = size - 1; i >= 1; i--) {
            int max = extractMax();
            heap[i] = max;
        }
        return heap;
    }

}
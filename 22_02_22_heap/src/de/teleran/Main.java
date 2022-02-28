package de.teleran;

public class Main {



    public static void main(String[] args) {
        int[] integers = {36, 31, 20, 40, 23, 18, 15, 79, 27, 83};
        HeapService heapy = new HeapService(integers);
        int[] result = heapy.heapSort();

        for(int i = 0; i < result.length; i++){
            System.out.println(result[i]);
        }
    }
}

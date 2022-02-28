package de.teleran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeapServiceTest {


@Test
void heapServiceTest_1() {

    int[] integers = {36, 31, 20, 40, 23, 18, 15, 79, 27, 83};
    HeapService heapy = new HeapService(integers);
    int[] result = heapy.heapSort();

    assertArrayEquals(result, integers);
}
    @Test
    void heapServiceTest_2() {

        int[] integers = {36, 31, 31, 40, 23, 18, 15, 79, 27, -9};
        HeapService heapy = new HeapService(integers);
        int[] result = heapy.heapSort();

        assertArrayEquals(result, integers);
    }
    void heapServiceTest_3() {

        int[] integers = {0,0,0,0,0,0};
        HeapService heapy = new HeapService(integers);
        int[] result = heapy.heapSort();
        assertArrayEquals(result, integers);
    }

}


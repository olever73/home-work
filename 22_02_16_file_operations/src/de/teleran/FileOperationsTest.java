package de.teleran;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileOperationsTest {
    FileOperations fileOperations = new FileOperations();

    @Test
    public void testWriteReadStrings() throws IOException {
        List<String> strings = Arrays.asList("Hello", "world", "friends");
        fileOperations.writeToFile(strings, "output.txt");

        List<String> readStrings = fileOperations.readFromFile("output.txt");
        assertEquals(strings, readStrings);
    }

    @Test
    public void testWriteReadInts() throws IOException {
        List<Integer> ints = Arrays.asList(4,15,-9);
        fileOperations.writeNumbers(ints, "numbers.txt");

        List<Integer> readInts = fileOperations.readNumbers("numbers.txt");
        assertEquals(ints, readInts);
    }
}
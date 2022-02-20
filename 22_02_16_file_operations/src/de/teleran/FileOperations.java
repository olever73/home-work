package de.teleran;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


public class FileOperations {
    public static void main(String... args) throws IOException {




}

    /**
     * Writes the strings into the file, one string as one line
     *
     * @param strings
     * @param filename
     * @return
     */
    public static String writeToFile(List<String> strings, String filename) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(filename)) {
            for (String string : strings) {
                fos.write(string.getBytes());

                fos.write(System.lineSeparator().getBytes());
            }
        }
       return filename;
    }


    /**
     * Creates a list of strings based on the file
     *
     * @param filename
     * @return
     */
    public static List<String> readFromFile(String filename) throws IOException {
        try (FileInputStream fis = new FileInputStream(filename)) {
            byte[] bytes = new byte[fis.available()];
            fis.read(bytes);
            String input = new String(bytes);
            return Arrays.asList(input.split(System.lineSeparator()));
        }
    }

    /**
     * Write the numbers into the file so that the file has one string composed from the numbers written one by
     * one with the delimiter " ".
     * <p>
     * {4, 15, -9} -> "4 15 -9"
     *
     * @param numbers
     * @param filename
     */
    public static void writeNumbers(List<Integer> numbers, String filename)throws IOException {
            try (FileOutputStream fos = new FileOutputStream(filename)) {
                if (numbers == null || numbers.size() == 0)
                    return;

                StringBuilder sb = new StringBuilder();
                Iterator<Integer> iterator = numbers.iterator();

                sb.append(iterator.next());
                while (iterator.hasNext()) {
                    sb.append(" ").append(iterator.next());
                }

                fos.write(sb.toString().getBytes());
            }
        }


    /**
     * "4 15 -9" -> {4, 15, -9}
     *
     * @param filename
     * @return
     */
    public static List<Integer> readNumbers(String filename)throws IOException {
        try (FileInputStream fis = new FileInputStream(filename)) {
            byte[] bytes = new byte[fis.available()];
            fis.read(bytes);
            String input = new String(bytes);

            String[] stringNumbers = input.split(" ");
            List<Integer> res = new ArrayList<>();
            for (String stringNumber : stringNumbers) {
                res.add(Integer.valueOf(stringNumber));
            }
            return res;
        }
    }
}
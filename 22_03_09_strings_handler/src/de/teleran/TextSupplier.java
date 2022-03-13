package de.teleran;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

public class TextSupplier implements Runnable {

    private final String filename;
    private final BlockingQueue<String> queue;

    public TextSupplier(String filename, BlockingQueue<String> queue) {
        this.filename = filename;
        this.queue = queue;
    }

    @Override
    public void run() {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            while ((line=br.readLine()) !=null){
                queue.add(line);
            }
            // TODO read lines from the file one by one and place them into the queue
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
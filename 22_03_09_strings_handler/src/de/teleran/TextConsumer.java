package de.teleran;

import de.teleran.operation.IStringOperation;

import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;

public class TextConsumer implements Runnable {
    public static final String DELIMETR = "#";
    public static final String WRONG_FORMAT = "wrong format";
    public static final String WRONG_OPERATION = "operation not supported";
    private final BlockingQueue<String> queue;
    private final OperationContext operationContext;
    private final PrintWriter pw;

    public TextConsumer(BlockingQueue<String> queue, OperationContext operationContext, PrintWriter pw) {
        this.queue = queue;
        this.operationContext = operationContext;
        this.pw = pw;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String line = queue.take();
                String newLine = handleLine(line);
                pw.println(newLine);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String handleLine(String line) {
        String[] splitline = line.split(DELIMETR);
        if (splitline.length != 2)
            return line + DELIMETR + WRONG_FORMAT;

        // TODO implement
        String operationName=splitline[0];
        String text=splitline[1];
        // TODO fill the variables operationName and text. Check whether the format of the line is correct

        IStringOperation operation = operationContext.getOperation(operationName);
        if (operation == null)
            return line + DELIMETR + WRONG_OPERATION;
        // Check whether the operation exists
        String res = operation.operate(text);

        return res;
    }
}
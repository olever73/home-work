package de.teleran.operation;


public class UpperCaseOperation implements IStringOperation {
    @Override
    public String operate(String line) {

        return line.toUpperCase();
    }

    @Override
    public String getName() {
        return "to_upper_case";
    }
}
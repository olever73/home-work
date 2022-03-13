package de.teleran.operation;

public class LowerCaseoperation implements IStringOperation {
    @Override
    public String operate(String line) {
        return line.toLowerCase();
    }

    @Override
    public String getName() {
        return "to_lower_case";
    }
}

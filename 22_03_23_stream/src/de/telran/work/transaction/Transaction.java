package de.telran.work.transaction;

public class Transaction {

    private  String uuid;
    private  String State;
    private long sum;
    private long date;

    public String getUuid() {
        return uuid;
    }

    public String getState() {
        return State;
    }

    public long getSum() {
        return sum;
    }

    public long getDate() {
        return date;
    }

    public void setState(String state) {
        State = state;
    }

    public Transaction(String uuid, String state, long sum, long date) {
        this.uuid = uuid;
        State = state;
        this.sum = sum;
        this.date = date;
    }


}

package de.teleran.account;

public class Account {
    private int id;
    private Double balance;
    private boolean isLocked;

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public Account(int id, Double balance, Boolean isLoced) {
        this.id = id;
        this.balance = balance;
        this.isLocked = isLoced;
    }
    public int getId() {
        return id;
    }

    public Double getBalance() {
        return balance;
    }



    public void setBalance(Double balance) {
        this.balance = balance;
    }




}

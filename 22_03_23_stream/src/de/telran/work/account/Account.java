package de.telran.work.account;

public class Account {
    public Account(String uuid, long sum) {
        this.uuid = uuid;
        this.sum = sum;
    }
    String uuid;
    long sum;
    boolean isLocked;

    public String getUuid() {
        return uuid;
    }
    public long getSum() {
        return sum;
    }

     public boolean isLocked(){
        return isLocked;
     }

     public void setLocked(boolean locked){
        isLocked=locked;
     }
}

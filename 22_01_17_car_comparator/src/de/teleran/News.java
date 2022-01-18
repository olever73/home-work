package de.teleran;

public class News implements Comparable<News>{
    String text;

    // from 1 to 10
    int priority;

    public String getText() {
        return text;
    }

    public int getPriority() {
        return priority;
    }

    public News(String text, int priority) {
        this.text = text;
        this.priority = priority;
    }

    //TODO the news which is of a higher priority must go first, if the priorities are equal, the shorter news
    // must go first.
    @Override
    public int compareTo(News o) {
        int res = o.priority-this.priority;
        if (res != 0)
            return res;
        return o.text.length()-this.text.length();
    }
    @Override
    public String toString() {
        return "News{" + "text='" + text + '\'' + ", priority=" + priority + '}';
    }

}
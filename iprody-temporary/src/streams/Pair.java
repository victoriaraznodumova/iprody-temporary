package streams;

public class Pair {
    private int previous;
    private int next;

    public Pair(int previous, int next) {
        this.previous = previous;
        this.next = next;
    }

    public int getPrevious() {
        return previous;
    }

    public void setPrevious(int previous) {
        this.previous = previous;
    }

    public int getNext() {
        return next;
    }

    public void setNext(int next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "previous=" + previous +
                ", next=" + next +
                '}';
    }

}

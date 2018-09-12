

public class Queue {
    public int maxSize;
    public char[] queue;
    private int front​;
    private int rear​;
    public int items;

    public Queue(int s) {
        maxSize = s;
        queue = new char[maxSize];
        front​ = 0;
        rear​ = maxSize;
        items = 0;
    }

    public void insert(char i) {
        if (rear​ == 0)
            rear​ = maxSize;
        queue[--rear​] = i;
        items++;
    }

    public int remove() {
        int k;
        if (front​ == 0) {
            front​ = maxSize - 1;
            int temp = queue[front​];
            k = temp;
        } else {
            int temp = queue[--front​];
            k = temp;
        }
        items--;
        return k;
    }

    public int peek() {
        return queue[front​];
    }

    public boolean isEmpty() {
        return (items == 0);
    }

    public boolean isFull() {
        return (items == maxSize);
    }

    public int size() {
        return items;
    }
}
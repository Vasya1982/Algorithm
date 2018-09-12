

public class Pyramida {
    private int maxSize;
    public char[] stack;
    public int top​;

    public Pyramida(int size) {
        this.maxSize = size;
        this.stack = new char[this.maxSize];
        this.top​ = -1;
    }

    public void push(char i) {
        this.stack[++this.top​] = i;
        System.out.println(stack[top​]);
    }

    public int pop() {
        System.out.println(stack[--top​]);
        return this.stack[this.top​];
    }

    public char peek() {
        return this.stack[this.top​];
    }

    public boolean isEmpty() {
        return (this.top​ == -1);
    }

    public boolean isFull() {
        return (this.top​ == this.maxSize - 1);
    }
}


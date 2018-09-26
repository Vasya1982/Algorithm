package Fine;

public class Node {
    public int key;
    public char data; //использую L,R для определения позиции в дереве
    public Node leftChild;
    public Node rightChild;

    public void printNode() {
        System.out.print(key +"" +data+" ");
    }
}

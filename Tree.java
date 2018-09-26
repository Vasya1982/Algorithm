package Fine;


public class Tree {
    public Node root;

    public Node find(int k) {
        Node current = root;
        while (current.key != k) {
            if (k < current.key) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    public void insert(int key, char data) {
        Node node = new Node();
        node.key = key;
        node.data = data;
        if (root == null) {
            root = node;
        } else {
            Node current = root;
            Node prev;
            while (true) {
                prev = current;
                if (key < prev.key) {
                    current = current.leftChild;
                    node.data = 'L';
                    if (current == null) {
                        prev.leftChild = node;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    node.data = 'R';
                    if (current == null) {
                        prev.rightChild = node;
                        return;
                    }
                }
            }
        }
    }

    public void print(Node Root) {
        if (Root != null) {
            Root.printNode();
            print(Root.rightChild);
            print(Root.leftChild);
        }
    else
        System.out.println();
    }

    public int M(Node Root) {
        if (Root == null) {
            return 0;
        } else {
            return 1 + Math.max(M(Root.rightChild), M(Root.leftChild));
        }
    }

}




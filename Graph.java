package Fine;

public class Graph {
    private final int MAX_VERTS = 32;
    private Vertex[] vertexList;
    private int[][] adjMat;
    private int size;

    private Stack stack;
    private Queue queue;

    public Graph() {
        stack = new Stack(MAX_VERTS);
        queue = new Queue(MAX_VERTS);
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        size = 0;
//        for (int i = 0; i < MAX_VERTS; i++) {
//            for (int j = 0; j < MAX_VERTS; j++) {
//                adjMat[i][j] = 0;
//            }
//        }
    }

    public void addVertex(char label) {
        vertexList[size++] = new Vertex(label);
    }

    public void addEdge(int start, int end, int length) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int vertex) {
        System.out.println(vertexList[vertex].label);
    }

    private int getAdjUnvisitedVertex(int ver) {
        for (int i = 0; i < size; i++) {
            if (adjMat[ver][i] == 1 && !vertexList[i].wasVisited) {
                return i;
            }
        }
        return -1;
    }

    //depth-first search
    public void dfs() {
        vertexList[0].wasVisited = true;
        displayVertex(0);
        stack.push(0);

        while (!stack.isEmpty()) {
            int v = getAdjUnvisitedVertex(stack.peek());
            if (v == -1) {
                stack.pop();
            } else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                stack.push(v);
            }
        }
        for (int i = 0; i < size; i++) {
            vertexList[i].wasVisited = false;
        }
    }

    //breadth-first search
    public void bfs() {
        vertexList[0].wasVisited = true;
        displayVertex(0);
        queue.insert(0);
        int v2;
        while (!queue.isEmpty()) {
            int v1 = queue.remove();
            while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
                vertexList[v2].wasVisited = true;
                displayVertex(v2);
                queue.insert(v2);

            }
        }
        for (int i = 0; i < size; i++) {
            vertexList[i].wasVisited = false;
        }
        System.out.println();


    }
}

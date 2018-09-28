package Fine;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Graph graph = new Graph();
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');
        graph.addVertex('G');
        graph.addVertex('H');
        graph.addVertex('I');
        graph.addVertex('J');


        graph.addEdge(0, 1, 5); //AB
        graph.addEdge(1, 2, 3); //BC
        graph.addEdge(0, 3, 7); //AD
        graph.addEdge(3, 4, 1); //DE

        graph.addEdge(2, 5, 2); //CF
        graph.addEdge(5, 6, 8); //FG
        graph.addEdge(5, 7, 8); //FH
        graph.addEdge(6, 8, 4); //GI
        graph.addEdge(7, 8, 11); //HI
        graph.addEdge(4, 8, 5); //EI
        graph.addEdge(8, 9, 6); //IJ

        graph.dfs();
System.out.println();
        graph.bfs();






    }
}

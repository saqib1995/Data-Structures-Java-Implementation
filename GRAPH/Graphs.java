import java.util.LinkedList;

public class Graphs {

    public LinkedList<Integer> adjacencyList[];
    public Integer[][] adjacencyMatrix;

    public Graphs(int numOfVertices) {

        adjacencyList = new LinkedList[numOfVertices];

        for (int i = 0; i < numOfVertices; i++)
            adjacencyList[i] = new LinkedList();

        adjacencyMatrix = new Integer[numOfVertices][numOfVertices];
        for(int i = 0 ; i < numOfVertices ; i++) {
            for(int j = 0 ; j < numOfVertices ; j++) {
                adjacencyMatrix[i][j] = 0;
            }
        }

    }

    public void addEdgeToList(int source, int destination) {
        adjacencyList[source].add(destination);
    }

    public void addEdgeToMatrix(int source, int destination) {
        adjacencyMatrix[source][destination] = 1;
    }

    public void printAdjacencyList() {
        for(int i = 0 ; i < adjacencyList.length ; i++) {
            System.out.print(" " + adjacencyList[i]);

            System.out.println();
        }
    }

    public void printAdjacencyMatrix() {
        for(int i = 0 ; i < adjacencyMatrix.length ; i++) {
            for(int j = 0 ; j < adjacencyMatrix.length ; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}

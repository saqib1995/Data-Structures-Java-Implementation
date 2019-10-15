import java.util.*;

public class BreadthFirstSearch {
    private Graphs myGraph;
    private Queue<Integer> myQueue;
    private HashMap<Integer, Boolean> visitedNodes;
    private List<Integer> breadthFirstOrder;
    private Integer currentNode;

    public BreadthFirstSearch(Graphs myGraph) {
        this.myGraph = myGraph;
        myQueue = new LinkedList<>();
        visitedNodes = new HashMap<>();
        breadthFirstOrder = new ArrayList<>();
    }

    public void breadthFirstSearchOnList(Integer source) {

        myQueue.add(source);
        while(!myQueue.isEmpty()) {
            currentNode = myQueue.poll();
            if(!visitedNodes.containsKey(currentNode)) {
                visitedNodes.put(currentNode, true);
                breadthFirstOrder.add(currentNode);
            }

            if(breadthFirstOrder.size() == myGraph.adjacencyList.length) {
                break;
            }

            for(Integer i = 0 ; i < myGraph.adjacencyList[currentNode].size() ; i++) {
                if(!visitedNodes.containsKey(myGraph.adjacencyList[currentNode].get(i))) {
                    myQueue.add(myGraph.adjacencyList[currentNode].get(i));
                }

            }

        }
    }

    public void breadthFirstSearchOnMatrix(Integer source) {

        myQueue.add(source);
        while(!myQueue.isEmpty()) {
            currentNode = myQueue.poll();
            if(!visitedNodes.containsKey(currentNode)) {
                visitedNodes.put(currentNode, true);
                breadthFirstOrder.add(currentNode);
            }

            if(breadthFirstOrder.size() == myGraph.adjacencyMatrix.length) {
                break;
            }

            for(Integer i = 0 ; i < myGraph.adjacencyMatrix[currentNode].length ; i++) {
                if(myGraph.adjacencyMatrix[currentNode][i] != 0) {
                    if(!visitedNodes.containsKey(i)) {
                        myQueue.add(i);
                    }
                }


            }

        }


    }

    public void printBreadthFirstOrder(){
        System.out.println("this is the breadth first order");
        for(int i = 0 ; i < breadthFirstOrder.size() ; i++) {
            System.out.print(" " + breadthFirstOrder.get(i));
        }
    }





}

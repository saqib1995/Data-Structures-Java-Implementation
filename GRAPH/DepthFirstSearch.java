import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearch {
    private Graphs myGraph;
    private Stack<Integer> myStack;
    private HashMap<Integer, Boolean> visitedNodes;
    List<Integer> depthFirstOrder;
    Integer currentNode;

    public DepthFirstSearch(Graphs myGraph) {
        this.myGraph = myGraph;
        myStack = new Stack<>();
        visitedNodes = new HashMap<>();
        depthFirstOrder = new ArrayList<>();


    }

    public void depthFirstSearchOnList(Integer source) {
        myStack.add(source);


        while(!myStack.isEmpty()) {

            currentNode = myStack.pop();
            visitedNodes.put(currentNode, true);
            depthFirstOrder.add(currentNode);

            for(Integer i = 0 ; i < myGraph.adjacencyList[currentNode].size() ; i++) {
                if(!visitedNodes.containsKey(myGraph.adjacencyList[currentNode].get(i))) {
                   myStack.add(myGraph.adjacencyList[currentNode].get(i));
                   break;
                }
            }


        }

        if(visitedNodes.size() < myGraph.adjacencyList.length) {
            for(int i = 0 ; i < myGraph.adjacencyList.length ; i++) {
                if(!visitedNodes.containsKey(i)) {
                    depthFirstSearchOnList(i);
                }
            }

        }


        System.out.println("visited size: " + visitedNodes.size());
        System.out.println("no of vertices: "+ myGraph.adjacencyList.length);
    }

    public void depthFirstSearchOnMatrix(Integer source) {
        myStack.add(source);


        while(!myStack.isEmpty()) {

            currentNode = myStack.pop();
            visitedNodes.put(currentNode, true);
            depthFirstOrder.add(currentNode);

            for(Integer i = 0 ; i < myGraph.adjacencyMatrix[currentNode].length ; i++) {
                if(myGraph.adjacencyMatrix[currentNode][i] != 0) {
                    if(!visitedNodes.containsKey(i)) {
                        myStack.add(i);
                        break;
                    }
                }
            }
        }
    }


    public void printDepthFirstOrder() {
        System.out.println();
        for(Integer i : depthFirstOrder) {
            System.out.print(" " + i);
        }
    }




}

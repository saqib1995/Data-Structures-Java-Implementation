import java.util.HashMap;
import java.util.Stack;

public class TopologicalSorting {

    Graphs myGraph;
    Stack<Integer> myStack;
    HashMap<Integer, Boolean> visitedVertices;

    public TopologicalSorting(Graphs myGraph) {
        this.myGraph = myGraph;
        myStack = new Stack<>();
        visitedVertices = new HashMap<>();

    }


    public void SortTopologically(Integer source) {

        for(Integer i = 0 ; i < myGraph.adjacencyList.length ; i++) {
            if(!visitedVertices.containsKey(myGraph.adjacencyList[i]) ) {
                visitedVertices.put(i, true);
                for(Integer j : myGraph.adjacencyList[i]) {
                    SortTopologically(j);
                }
            }
        }
        

        if(!visitedVertices.containsKey(source)) {
            visitedVertices.put(source, true);
            for(Integer j : myGraph.adjacencyList[source]) {
                SortTopologically(j);
            }
            myStack.add(source);
        }

    }


    public void printSortedOrder() {
        while(!myStack.isEmpty()) {
            System.out.print(" " + myStack.pop());
        }
    }


}

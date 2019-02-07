public class Node {

    int value;
    Node parent;
    Node leftChild;
    Node rightChild;

    Node (int value) {
        this.value = value;
        this.leftChild = null;
        this.rightChild = null;
        this.parent = null;
    }
}

public class LinkedList {

    Node head;

    public LinkedList() {
        this.head = null;
    }

    public Node createNode(int value) {
        Node node = new Node(value , null);
        return node;
    }

    public void printList(){
        Node iterator = head;
        while(iterator != null) {
            System.out.println(iterator.value);
            iterator = iterator.next;
        }
    }

    public void insertNode(Node node) {
        if(this.head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    public void deleteNode(Node node) {
        if(head == node) {
            head = head.next;
        } else {
            Node previous = head;
            while(previous.next != node) {
                previous = previous.next;
            }
            previous.next = node.next;
        }
    }

    public Node searchNode(int value) {
        Node iterate = head;
        while(iterate!= null) {
            if(iterate.value == value) {
                return iterate;
            }
            iterate = iterate.next;
        }
        return null;
    }

}

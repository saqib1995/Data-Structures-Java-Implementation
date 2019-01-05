public class LinkedList {

    private Node head;

    public LinkedList() {
        this.head = null;
    }

    private Node createNode(int value) {
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

    public void insert(int value) {
        Node insertNode = createNode(value);
        if(this.head == null) {
            head = insertNode;
        } else {
            Node currentNode = head;
            while(currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = insertNode;
        }
    }

    public void delete(int value) {

        while(head != null && head.value == value) {
            head = head.next;
        }
        if(head == null) {
            return;
        }

        Node currentNode = head;
        while(currentNode != null) {
            Node previousDeleteNode = searchPreviousOf(currentNode, value);
            if(previousDeleteNode != null) {
                    previousDeleteNode.next = previousDeleteNode.next.next;
            }
            currentNode = previousDeleteNode;
        }

    }

    private Node searchPreviousOf(Node node , int value) {
        if(node == null) {
            return null;
        }
        while(node.next != null && node.next.value != value) {
            node = node.next;
        }
        if(node.next != null && node.next.value == value) {
            return node;
        }
        return null;
    }


    public boolean searchNode(int value) {
        Node iterate = head;
        while(iterate!= null) {
            if(iterate.value == value) {
                return true;
            }
            iterate = iterate.next;
        }
        return false;
    }

}

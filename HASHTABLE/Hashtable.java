public class Hashtable<T,V>  {
    Node<T,V>[] hashTable;
    final float loadFactor;
    int count;

    public Hashtable() {
        hashTable = new Node[11];
        loadFactor = 0.5f;
        count = 0;
    }

    public void put(T key , V value) {
        float load = (float) count/hashTable.length;
        if(load >= loadFactor) {
            count = 0;
            Node[] newHashTable;

            newHashTable = doubleSizeArray(2 * hashTable.length);

            for(int i = 0 ; i < hashTable.length ; i++) {
                Node<T,V> tempNode = hashTable[i];
                while(tempNode != null) {
                    putHelper(newHashTable , tempNode.key , tempNode.value);
                    tempNode = tempNode.next;
                }
            }
            hashTable = newHashTable;
        }

        putHelper(hashTable , key , value);


    }

    private void putHelper(Node[] hashTable , T key , V value) {

        int tablePosition = hashValue(key);
        Node node = hashTable[tablePosition];

        if (node == null) {
            hashTable[tablePosition] = new Node(key , value , null);
            count++;
            return;
        }

        while(node.next!= null && node.key != key) {
            node = node.next;
        }

        if (node.key == key) {
            node.value = value;
        } else if(node.next == null) {
            node.next = new Node(key , value , null);
            count++;
        }

    }

    public V get(T key) {
        int tablePosition = hashValue(key);
        if(hashTable[tablePosition] == null) {
            return null;
        }

        Node<T,V> iteratorNode = hashTable[tablePosition];
        while(iteratorNode.next != null && iteratorNode.key != key) {
            iteratorNode = iteratorNode.next;
        }

        if(iteratorNode.key == key) {
            return iteratorNode.value;
        } else {
            return null;
        }

    }

    public boolean isEmpty() {
        if(count == 0) {
            return true;
        }
        return false;
    }

    public V remove(T key) {
        int tablePosition = hashValue(key);
        V removedValue;
        if(hashTable[tablePosition] == null) {
            return null;
        }

        Node<T,V> iteratorNode = hashTable[tablePosition];
        while(iteratorNode.next != null && iteratorNode.key != key) {
            iteratorNode = iteratorNode.next;
        }

        if(iteratorNode.key == key && iteratorNode.next == null) {
            removedValue = iteratorNode.value;
            iteratorNode.value = null;
            return removedValue;
        } else {
            removedValue = iteratorNode.value;
            iteratorNode.value = iteratorNode.next.value;
            iteratorNode.key = iteratorNode.next.key;
            iteratorNode.next = iteratorNode.next.next;
            return removedValue;
        }

    }

    private Node[] doubleSizeArray(int newArrayLength) {
        Node[] array = new Node[newArrayLength];
        return array;
    }

    private int hashValue(T key) {
        int hashValue;
        hashValue = key.hashCode() % hashTable.length;
        return hashValue;
    }
}

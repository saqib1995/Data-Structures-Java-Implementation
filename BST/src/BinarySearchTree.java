public class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        this.root = null;

    }

    public void insert(int value) {

        Node insertingNode = new Node(value);

        if(root == null) {
            root = insertingNode;
            return;
        }

        Node iteratingNode = root;
        insertHelper(insertingNode , iteratingNode);
        //Node parentNode = null;

        /*while(iteratingNode != null) {
            //parentNode = iteratingNode;
            if(insertingNode.value < iteratingNode.value) {
                if(iteratingNode.leftChild == null) {
                    iteratingNode.leftChild = insertingNode;
                    insertingNode.parent = iteratingNode;
                    return;
                } else {
                    iteratingNode = iteratingNode.leftChild;
                }
            } else if(insertingNode.value > iteratingNode.value){
                if(iteratingNode.rightChild == null) {
                    iteratingNode.rightChild = insertingNode;
                    insertingNode.parent = iteratingNode;
                    return;
                } else {
                    iteratingNode = iteratingNode.rightChild;
                }
            }
        }

        if(iteratingNode == null) {
            return;
        }*/
    }


    private void insertHelper(Node insertingNode , Node iteratingNode) {

        if(insertingNode.value < iteratingNode.value && iteratingNode.leftChild == null) {
            iteratingNode.leftChild = insertingNode;
            insertingNode.parent = iteratingNode;
        } else if(insertingNode.value < iteratingNode.value && iteratingNode.leftChild != null) {
            insertHelper(insertingNode , iteratingNode.leftChild);
        }

        if(insertingNode.value > iteratingNode.value && iteratingNode.rightChild == null) {
            iteratingNode.rightChild = insertingNode;
            insertingNode.parent = iteratingNode;
        } else if((insertingNode.value > iteratingNode.value && iteratingNode.rightChild != null)) {
            insertHelper(insertingNode , iteratingNode.rightChild);
        }
    }

    public void delete(int value) {
        Node parentNode;
        if(root == null) {
            return;
        }

        deleteHelper(root , value);

        //Node deletingNode = new Node(value);
        //Node iteratingNode = root;

/*
        while(iteratingNode.value != deletingNode.value || iteratingNode != null) {
            if(deletingNode.value < iteratingNode.value) {
                iteratingNode = iteratingNode.leftChild;
            } else {
                iteratingNode = iteratingNode.rightChild;
            }
        }

        if(iteratingNode == null) {
            return false;
        }

        if(iteratingNode.leftChild == null && iteratingNode.rightChild == null) {
            parentNode = iteratingNode.parent;
            if(deletingNode.value < parentNode.value) {
                parentNode.leftChild = null;
            } else {
                parentNode.rightChild = null;
            }
            return true;
        }

        if(iteratingNode.leftChild == null && iteratingNode.rightChild != null) {
            parentNode = iteratingNode.parent;
            if(deletingNode.value < parentNode.value) {
                parentNode.leftChild = deletingNode.rightChild;
            } else {
                parentNode.rightChild = deletingNode.rightChild;
            }
            return true;
        }

        if(iteratingNode.leftChild != null && iteratingNode.rightChild == null) {
            parentNode = iteratingNode.parent;
            if(deletingNode.value < parentNode.value) {
                parentNode.leftChild = deletingNode.leftChild;
            } else {
                parentNode.rightChild = deletingNode.leftChild;
            }
            return true;
        }

        if(iteratingNode.leftChild != null && iteratingNode.rightChild != null) {
            Node replacementNode = minimum(iteratingNode);
            replacementNode.rightChild = iteratingNode.rightChild;
            replacementNode.parent = iteratingNode.parent;
            return true;
        }

        return false;*/
    }

    private void deleteHelper(Node iteratingNode , int value) {

        if(iteratingNode.value == value && iteratingNode.leftChild == null && iteratingNode.rightChild == null) {
            Node parentNode = iteratingNode.parent;
            if(parentNode.leftChild == iteratingNode) {
                parentNode.leftChild = null;
            } else {
                parentNode.rightChild = null;
            }
        }

        if(iteratingNode.value == value && iteratingNode.leftChild == null && iteratingNode.rightChild != null) {
            Node parentNode = iteratingNode.parent;
            if(parentNode.leftChild == iteratingNode) {
                parentNode.leftChild = iteratingNode.rightChild;
                iteratingNode.rightChild.parent = parentNode;
            } else {
                parentNode.rightChild = iteratingNode.rightChild;
                iteratingNode.rightChild.parent = parentNode;
            }
        } else if(iteratingNode.value == value && iteratingNode.leftChild != null && iteratingNode.rightChild == null) {
            Node parentNode = iteratingNode.parent;
            if(parentNode.leftChild == iteratingNode) {
                parentNode.leftChild = iteratingNode.leftChild;
                iteratingNode.leftChild.parent = parentNode;
            } else {
                parentNode.rightChild = iteratingNode.leftChild;
                iteratingNode.leftChild.parent = parentNode;
            }
        }


        if(value < iteratingNode.value && iteratingNode.leftChild == null) {
            return;
        } else if(value < iteratingNode.value && iteratingNode.leftChild != null) {
            deleteHelper(iteratingNode.leftChild , value);
        }

        if(value > iteratingNode.value && iteratingNode.rightChild == null) {
            return;
        } else if (value > iteratingNode.value && iteratingNode.rightChild != null) {
            deleteHelper(iteratingNode.rightChild , value);
        }


    }


    public Node search(Node iteratingNode, int value) {

        if (iteratingNode == null || iteratingNode.value == value) {
            return iteratingNode;
        }

        //while(iteratingNode.leftChild != null || iteratingNode.rightChild != null) {
           // while(iteratingNode != null && iteratingNode.value != value) {
             //   if (value < iteratingNode.value && iteratingNode.leftChild != null) {
              //      iteratingNode = iteratingNode.leftChild;
              //  } else if (value > iteratingNode.value && iteratingNode.rightChild != null) {
              //      iteratingNode = iteratingNode.rightChild;
              //  }
           // }
        //}

        if(value < iteratingNode.value) {
            return search(iteratingNode.leftChild , value);
        } else {
            return search(iteratingNode.rightChild , value);
        }

    }

    public Node minimum(Node iteratingNode) {

        if(iteratingNode.leftChild == null && iteratingNode.rightChild == null) {
            return iteratingNode;
        } else if (iteratingNode.leftChild == null && iteratingNode.rightChild != null) {
            return iteratingNode;
        }

        return minimum(iteratingNode.leftChild);
    }

    public Node maximum(Node iteratingNode) {

        if(iteratingNode.leftChild == null && iteratingNode.rightChild == null) {
            return iteratingNode;
        } else if (iteratingNode.leftChild != null && iteratingNode.rightChild == null) {
            return iteratingNode;
        }

        return maximum(iteratingNode.rightChild);
    }
}

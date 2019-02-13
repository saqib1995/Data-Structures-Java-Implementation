public class BinarySearchTree {
    Node root;
    int preOrderIndex;

    public BinarySearchTree() {
        this.root = null;
        preOrderIndex = 0;

    }

    public void insert(int value) {


        Node insertingNode = new Node(value);
        if(root == null) {
            System.out.println("inserting at root");
            root = insertingNode;
            return;
        }
        Node iteratingNode = root;
        insertHelper(insertingNode , iteratingNode);

    }


    private void insertHelper(Node insertingNode , Node iteratingNode) {
        if(iteratingNode == null) {
            iteratingNode = insertingNode;
        }
        if(insertingNode.value <= iteratingNode.value) {
            if(iteratingNode.leftChild != null) {
                insertHelper(insertingNode, iteratingNode.leftChild);
            } else {
                    System.out.println("inserting " + insertingNode.value + " to left of " + iteratingNode.value);
                    iteratingNode.leftChild = insertingNode;
                    return;
            }
        }
        if(insertingNode.value >= iteratingNode.value) {
            if(iteratingNode.rightChild != null) {
                insertHelper(insertingNode, iteratingNode.rightChild);
            } else {
                System.out.println("inserting " + insertingNode.value + " to right of " + iteratingNode.value);
                iteratingNode.rightChild = insertingNode;
                return;
            }
        }
    }


    public void delete(int value) {
        if(root == null) {
            return;
        }
        deleteHelper(root , value);

    }

    private void deleteHelper(Node iteratingNode , int value) {

        if(iteratingNode.value == value) {
            if(iteratingNode.leftChild == null && iteratingNode.rightChild == null) {
                Node parentNode = searchParent(value);
                if(value <= parentNode.value) {
                    System.out.println("deleted " + value + "from " + parentNode.value);
                    parentNode.leftChild = null;
                } else {
                    System.out.println("deleted " + value + "from " + parentNode.value);
                    parentNode.rightChild = null;
                }
            } else if(iteratingNode.leftChild == null || iteratingNode.rightChild == null) {
                Node iteratingChild;
                if(iteratingNode.leftChild != null) {
                    iteratingChild = iteratingNode.leftChild;
                } else {
                    iteratingChild = iteratingNode.rightChild;
                }

                Node parentNode = searchParent(value);
                if(value <= parentNode.value) {
                    parentNode.leftChild = iteratingChild;
                } else {
                    parentNode.rightChild = iteratingChild;
                }
            } else {
                Node minimumNode = minimum(iteratingNode.rightChild);
                int temp = minimumNode.value;
                minimumNode.value = iteratingNode.value;
                iteratingNode.value = temp;

                delete(minimumNode.value);
            }
        } else {
            if(iteratingNode.leftChild != null && value <= iteratingNode.value) {
                deleteHelper(iteratingNode.leftChild , value);
            } else if (iteratingNode.rightChild != null && value >= iteratingNode.value){
                deleteHelper(iteratingNode.rightChild , value);
            }
        }
    }

    public boolean search(int value) {
        if(root == null) {
            return false;
        } else {
            return search(root , value);
        }
    }


    private boolean search(Node iteratingNode, int value) {
        if(iteratingNode.value == value) {
            return true;
        }

        if(value <= iteratingNode.value && iteratingNode.leftChild != null) {
            return search(iteratingNode.leftChild, value);
        } else if(value >= iteratingNode.value && iteratingNode.rightChild != null) {
            return search(iteratingNode.rightChild, value);
        }
        return false;
    }

    private Node searchParent(int value) {
        Node childNode = new Node(value);

        if(childNode.value == root.value) {
            return null;
        }
        Node iteratingNode = root;
        while(iteratingNode.leftChild.value != childNode.value && iteratingNode.rightChild.value != childNode.value) {
            if(childNode.value <= iteratingNode.value) {
                iteratingNode = iteratingNode.leftChild;
            } else {
                iteratingNode = iteratingNode.rightChild;
            }
        }
        return iteratingNode;
    }

    public void inorder() {
        if(root == null) {
            return;
        } else {
            inorder(root);
        }
    }

    private void inorder(Node iteratingNode) {
        if(iteratingNode == null) {
            return;
        } else if(iteratingNode.leftChild == null && iteratingNode.rightChild == null) {
            System.out.println(iteratingNode.value);
        } else {
            if(iteratingNode.leftChild != null) {
                inorder(iteratingNode.leftChild);
            }

            System.out.println(iteratingNode.value);

            if(iteratingNode.rightChild != null) {
                inorder(iteratingNode.rightChild);
            }
        }
    }

    public void preorder() {
        preorder(root);
    }

    private void preorder(Node iteratingNode) {
        if(iteratingNode != null) {
            System.out.println(iteratingNode.value);
        }
        if(iteratingNode.leftChild != null) {
            preorder(iteratingNode.leftChild);
        }

        if(iteratingNode.rightChild != null) {
            preorder(iteratingNode.rightChild);
        }
    }

    public void postorder() {
        postorder(root);
    }

    private void postorder(Node iteratingNode) {
        if(iteratingNode.rightChild != null) {
            postorder(iteratingNode.rightChild);
        }
        if(iteratingNode.leftChild != null) {
            postorder(iteratingNode.leftChild);
        }
        System.out.println(iteratingNode.value);
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



    public Node inorderplusPreorder(int[] inorderArray , int[] preorderArray) {
        int inorderLength = inorderArray.length;

        root = constructTree(inorderArray , preorderArray , 0 , inorderLength - 1);
        return  root;
    }

    private Node constructTree(int[] inorderArray , int[] preorderArray , int inorderStart , int inorderEnd) {


        if(inorderStart > inorderEnd) {
            return null;
        }

        Node iteratingNode = new Node(preorderArray[preOrderIndex]);
        preOrderIndex++;

        if(inorderStart == inorderEnd) {
            return iteratingNode;
        }

            int k = 0;
            for(int i = inorderStart ; i <= inorderEnd ; i++) {
                if(inorderArray[i] == iteratingNode.value)  {
                    k = i;
                    break;
                }
            }

            iteratingNode.leftChild = constructTree(inorderArray , preorderArray , inorderStart , k - 1);
            iteratingNode.rightChild = constructTree(inorderArray , preorderArray , k + 1 , inorderEnd);


        return iteratingNode;
    }








}

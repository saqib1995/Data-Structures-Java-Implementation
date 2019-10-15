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
    }

    private void insertHelper(Node insertingNode , Node iteratingNode) {
        if(iteratingNode == null) {
            iteratingNode = insertingNode;
        }
        if(insertingNode.value <= iteratingNode.value) {
            if(iteratingNode.leftChild != null) {
                insertHelper(insertingNode, iteratingNode.leftChild);
            } else {
                    iteratingNode.leftChild = insertingNode;
            }
        } else {
            if(iteratingNode.rightChild != null) {
                insertHelper(insertingNode, iteratingNode.rightChild);
            } else {
                iteratingNode.rightChild = insertingNode;
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
                    parentNode.leftChild = null;
                } else {
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
            } else if (iteratingNode.rightChild != null && value > iteratingNode.value){
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
        } else if(value > iteratingNode.value && iteratingNode.rightChild != null) {
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
        }
        inorder(iteratingNode.leftChild);
        System.out.println(iteratingNode.value);
        inorder(iteratingNode.rightChild);
    }

    public void preorder() {
        preorder(root);
    }

    private void preorder(Node iteratingNode) {
        if(iteratingNode == null) {
            return;
        }
        System.out.println(iteratingNode.value);
        preorder(iteratingNode.leftChild);
        preorder(iteratingNode.rightChild);
    }

    public void postorder() {
        postorder(root);
    }

    private void postorder(Node iteratingNode) {
        if(iteratingNode == null) {
            return;
        }
        postorder(iteratingNode.rightChild);
        postorder(iteratingNode.leftChild);
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



    public Node inorderPreorderTreeConstruct(int[] inorderArray , int[] preorderArray) {
        int inorderLength = inorderArray.length;
        int preOrderIndex = 0;
        root = constructTree(inorderArray , preorderArray , 0 , inorderLength - 1 , preOrderIndex);
        return  root;
    }

    private Node constructTree(int[] inorderArray , int[] preorderArray , int inorderStart , int inorderEnd , int preOrderIndex) {
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
        iteratingNode.leftChild = constructTree(inorderArray , preorderArray , inorderStart , k - 1 , preOrderIndex);
        iteratingNode.rightChild = constructTree(inorderArray , preorderArray , k + 1 , inorderEnd , preOrderIndex);
        return iteratingNode;
    }

    public void mirrorBST(Node iteratingNode) {
        Node temp;
        if(iteratingNode.leftChild == null && iteratingNode.rightChild == null) {
            return;
        } else {
            temp = iteratingNode.leftChild;
            iteratingNode.leftChild = iteratingNode.rightChild;
            iteratingNode.rightChild = temp;

        }

        if(iteratingNode.leftChild != null) {
            mirrorBST(iteratingNode.leftChild);
        }

        if(iteratingNode.rightChild != null) {
            mirrorBST(iteratingNode.rightChild);
        }
    }
}

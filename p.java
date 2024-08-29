import java.util.*;

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

 class BST {
     Node root;

     BST() {
        root = null;
    }

    // Insertion operation
     void insert(int value) {
        root = insertRec(root, value);
    }

     Node insertRec(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (value < root.val) {
            root.left = insertRec(root.left, value);
        } else if (value > root.val) {
            root.right = insertRec(root.right, value);
        }

        return root;
    }
 // Inorder traversal
    void inorder() {
        inorderRec(root);
    }

     void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.val + " ");
            inorderRec(root.right);
        }
    }

    //preorder travelsal

    void preorder()
    {
        preorderRec(root);
    }
    void preorderRec(Node root)
    {
        if(root!=null)
        {
System.out.print(root.val+" ");
preorderRec(root.left);
 preorderRec(root.right);
        }
    }

    //postorder travalsel

  void postorder() 
    {
        postorderRec(root);
    }

     void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.val + " ");
        }
    }

    //validation check for BST

     boolean isValidBST() {
    return isValidBSTRec(root, null, null, Integer.MIN_VALUE, Integer.MAX_VALUE);
}

 boolean isValidBSTRec(Node node, Node parent, String position, int minValue, int maxValue) {
    if (node == null) {
        return true;
    }

    int val = node.val;

    // Check for duplicate values
    if ((parent != null) && ((position.equals("left") && val == parent.val) || (position.equals("right") && val == parent.val))) {
        return false;
    }

    // Check if the value is within the valid range
    if (val <= minValue || val >= maxValue) {
        return false;
    }

    boolean isLeftValid = isValidBSTRec(node.left, node, "left", minValue, val);
    boolean isRightValid = isValidBSTRec(node.right, node, "right", val, maxValue);

    return isLeftValid && isRightValid;
}

    public static void main(String[] args) {
        BST bst = new BST();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Interactive Binary Search Tree");
        while (true) {
            System.out.println();
            System.out.println("1> INSERT INTO TREE");
            System.out.println("2> INORDER TRAVELSEL OF TREE");
            System.out.println("3> PRE-ORDER TRAVELSEL OF TREE");
            System.out.println("4> POST-ORDER TRAVELSEL OF TREE");
            System.out.println("5> VALIDATE FOR TREE");
            System.out.println("6>EXIT");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    int insertValue = scanner.nextInt();
                    bst.insert(insertValue);
                    break;
                
                case 2:
                    System.out.println("Inorder traversal of the BST:");
                    bst.inorder();
                    break;
                
                case 3:
                System.out.println("preorder travelsal of the bst");
                bst.preorder();
                break;

                case 4:
                System.out.println("postorder travelsal of the bst");
                bst.postorder();
                break;

                case 5:
                    boolean isValid = bst.isValidBST();
                    System.out.println("Is it a valid BST? " + isValid);
                    break;

                case 6:
                    scanner.close();
                    System.exit(0);
                    break;

                    

                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}
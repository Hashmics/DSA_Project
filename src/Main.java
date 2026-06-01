import java.util.Scanner;

// Node Class
class Node {

    int data;
    Node left, right;

    public Node(int value) {
        data = value;
        left = right = null;
    }
}

// BST Class
class BST {

    Node root;

    // Insert Operation
    Node insert(Node root, int value) {

        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (value < root.data) {
            root.left = insert(root.left, value);
        }
        else if (value > root.data) {
            root.right = insert(root.right, value);
        }

        return root;
    }

    // Search Operation
    boolean search(Node root, int key) {

        if (root == null) {
            return false;
        }

        if (root.data == key) {
            return true;
        }

        if (key < root.data) {
            return search(root.left, key);
        }
        else {
            return search(root.right, key);
        }
    }

    // Find Minimum Value
    Node minValue(Node root) {

        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    // Delete Operation
    Node delete(Node root, int value) {

        if (root == null) {
            return root;
        }

        if (value < root.data) {
            root.left = delete(root.left, value);
        }
        else if (value > root.data) {
            root.right = delete(root.right, value);
        }
        else {

            if (root.left == null) {
                return root.right;
            }
            else if (root.right == null) {
                return root.left;
            }

            Node temp = minValue(root.right);

            root.data = temp.data;

            root.right = delete(root.right, temp.data);
        }

        return root;
    }

    // Inorder Traversal
    void inorder(Node root) {

        if (root != null) {

            inorder(root.left);

            System.out.print(root.data + " ");

            inorder(root.right);
        }
    }

    // Preorder Traversal
    void preorder(Node root) {

        if (root != null) {

            System.out.print(root.data + " ");

            preorder(root.left);

            preorder(root.right);
        }
    }

    // Postorder Traversal
    void postorder(Node root) {

        if (root != null) {

            postorder(root.left);

            postorder(root.right);

            System.out.print(root.data + " ");
        }
    }
}

// Main Class
public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        BST tree = new BST();

        int choice, value;

        do {

            System.out.println("\n--- Binary Search Tree Menu ---");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. Inorder Traversal");
            System.out.println("5. Preorder Traversal");
            System.out.println("6. Postorder Traversal");
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");
            choice = input.nextInt();

            switch(choice) {

                case 1:
                    System.out.print("Enter value to insert: ");
                    value = input.nextInt();

                    tree.root = tree.insert(tree.root, value);

                    System.out.println("Value inserted.");
                    break;

                case 2:
                    System.out.print("Enter value to delete: ");
                    value = input.nextInt();

                    tree.root = tree.delete(tree.root, value);

                    System.out.println("Value deleted.");
                    break;

                case 3:
                    System.out.print("Enter value to search: ");
                    value = input.nextInt();

                    if (tree.search(tree.root, value)) {
                        System.out.println("Value found.");
                    }
                    else {
                        System.out.println("Value not found.");
                    }

                    break;

                case 4:
                    System.out.println("Inorder Traversal:");
                    tree.inorder(tree.root);
                    System.out.println();
                    break;

                case 5:
                    System.out.println("Preorder Traversal:");
                    tree.preorder(tree.root);
                    System.out.println();
                    break;

                case 6:
                    System.out.println("Postorder Traversal:");
                    tree.postorder(tree.root);
                    System.out.println();
                    break;

                case 7:
                    System.out.println("Program Ended.");
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }

        } while(choice != 7);

        input.close();
    }
}

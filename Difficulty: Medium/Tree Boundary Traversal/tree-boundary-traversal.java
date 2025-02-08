//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

class GFG {
    static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.equals('N')) return null;
        String[] s = str.split(" ");

        Node root = new Node(Integer.parseInt(s[0]));
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        // Starting from the second element
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            // Get and remove the front of the queue
            Node currNode = q.remove();

            // Get the current node's value from the string
            String currVal = s[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= s.length) break;
            currVal = s[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.right);
            }

            i++;
        }

        return root;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            Solution T = new Solution();

            ArrayList<Integer> res = T.boundaryTraversal(root);
            for (Integer num : res) System.out.print(num + " ");
            System.out.println();
            t--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
/*
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    ArrayList<Integer> boundaryTraversal(Node node) {
        ArrayList<Integer> result = new ArrayList<>();
        if (node == null) return result;
        // Add the root node (if it's not a leaf)
        if (!isLeaf(node)) {
            result.add(node.data);
        }
        // Traverse the left boundary (excluding leaves)
        addLeftBoundary(node.left, result);
        // Traverse all leaf nodes
        addLeaves(node, result);
        // Traverse the right boundary (excluding leaves, in reverse order)
        addRightBoundary(node.right, result);
        return result;
    }
    // Helper function to check if a node is a leaf
    private boolean isLeaf(Node node) {
        return node != null && node.left == null && node.right == null;
    }
    // Helper function to add the left boundary (excluding leaves)
    private void addLeftBoundary(Node node, ArrayList<Integer> result) {
        if (node == null || isLeaf(node)) return;
        result.add(node.data);
        // Traverse left if it exists, otherwise traverse right
        if (node.left != null) {
            addLeftBoundary(node.left, result);
        } else {
            addLeftBoundary(node.right, result);
        }
    }
    // Helper function to add all leaf nodes
    private void addLeaves(Node node, ArrayList<Integer> result) {
        if (node == null) return;
        if (isLeaf(node)) {
            result.add(node.data);
            return;
        }
        // Traverse left and right subtrees
        addLeaves(node.left, result);
        addLeaves(node.right, result);
    }
    // Helper function to add the right boundary (excluding leaves, in reverse order)
    private void addRightBoundary(Node node, ArrayList<Integer> result) {
        if (node == null || isLeaf(node)) return;
        // Traverse right if it exists, otherwise traverse left
        if (node.right != null) {
            addRightBoundary(node.right, result);
        } else {
            addRightBoundary(node.left, result);
        }
        // Add the node's data after recursion (to ensure reverse order)
        result.add(node.data);
    }
}

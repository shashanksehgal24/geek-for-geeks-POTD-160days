//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

// import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}


// } Driver Code Ends

// User function Template for Java

// class Node
// {
//     int data;
//     Node left, right;
// }



class Solution {
    public static ArrayList<Integer> KDistanceNodes(Node root, int targetVal, int k) {
        Map<Node, Node> parentMap = new HashMap<>();
        Node targetNode = buildParentMap(root, targetVal, parentMap);
        return bfsFromTarget(targetNode, parentMap, k);
    }

    private static Node buildParentMap(Node root, int targetVal, Map<Node, Node> parentMap) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        Node target = null;

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            if (curr.data == targetVal) {
                target = curr;
            }

            if (curr.left != null) {
                parentMap.put(curr.left, curr);
                queue.offer(curr.left);
            }

            if (curr.right != null) {
                parentMap.put(curr.right, curr);
                queue.offer(curr.right);
            }
        }

        return target;
    }

    private static ArrayList<Integer> bfsFromTarget(Node target, Map<Node, Node> parentMap, int k) {
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        queue.offer(target);
        visited.add(target);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            if (level == k) break;

            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();

                if (curr.left != null && !visited.contains(curr.left)) {
                    visited.add(curr.left);
                    queue.offer(curr.left);
                }

                if (curr.right != null && !visited.contains(curr.right)) {
                    visited.add(curr.right);
                    queue.offer(curr.right);
                }

                Node parent = parentMap.get(curr);
                if (parent != null && !visited.contains(parent)) {
                    visited.add(parent);
                    queue.offer(parent);
                }
            }

            level++;
        }

        ArrayList<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(queue.poll().data);
        }

        Collections.sort(result);
        return result;
    }
}



//{ Driver Code Starts.
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
            String s = br.readLine().trim();
            Node root = buildTree(s);
            Solution T = new Solution();
            int target = Integer.parseInt(br.readLine().trim());
            int k = Integer.parseInt(br.readLine().trim());
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = T.KDistanceNodes(root, target, k);
            for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            System.out.println();
            t--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends
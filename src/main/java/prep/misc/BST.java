package prep.misc;

import java.util.LinkedList;
import java.util.Queue;

public class BST {
    static class Node{
        int data;
        Node left, right, nextRight;
        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    Node root;
    BST(){
        this.root = null;
    }

    void insert(int data){
        root = insert(data, root);
    }

    Node insert(int data, Node node){
        if(node == null){
            return new Node(data);
        }else if(data < node.data){
            node.left = insert(data, node.left);
        }else{
            node.right = insert(data, node.right);
        }
        return node;
    }

    Node search(int data, Node node){
        if(node == null || node.data == data){
            return node;
        }
        if(node.data > data){
            return search(data, node.left);
        }
        return search(data, node.right);
    }

    void inOrder(){
        inOrder(root);
    }
    void inOrder(Node root){
        if(root != null){
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }
    }

    void levelOrderTrav(){
        if(root == null)
            return;
        Queue<Node> q = new LinkedList();
        q.add(root);

        while(q.size() > 0){
            Node curr = q.poll();
            System.out.print(curr.data+" ");
            if(curr.left != null)
                q.add(curr.left);
            if(curr.right != null)
                q.add(curr.right);
        }
    }

    int findHeight(Node root){
        if(root == null)
            return -1;
        int leftH = findHeight(root.left);
        int rightH = findHeight(root.right);

        return Math.max(leftH, rightH)+1;
    }

    boolean isValidBST(Node curr, int lowerBound, int upperBound){
        if(curr == null)
            return true;
        if(curr.data > lowerBound && curr.data < upperBound
            && isValidBST(curr.left, lowerBound, curr.data)
            && isValidBST(curr.right, curr.data, upperBound)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(4);
        bst.insert(2);
        bst.insert(5);
        bst.insert(3);
        bst.insert(-1);
        bst.insert(6);

        bst.inOrder();
        System.out.println();
        System.out.println(bst.findHeight(bst.root));
        bst.levelOrderTrav();

        System.out.println(bst.isValidBST(bst.root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

//    TODO tchgig ms Q: connect all children on same level
    public void connect(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        Node temp = null;
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                Node prev = temp;
                temp = q.poll();

                if (i > 0)
                    prev.nextRight = temp;

                if (temp.left != null)
                    q.add(temp.left);

                if (temp.right != null)
                    q.add(temp.right);
            }
            temp.nextRight = null;
        }
    }
}

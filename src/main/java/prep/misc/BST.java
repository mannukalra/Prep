package prep.misc;

import java.util.LinkedList;
import java.util.Queue;

public class BST {
    static class Node{
        int data;
        Node left, right;
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
    }
}

package BinaryTree;

/**
 * Created by shinsy1023 on 2016. 11. 21..
 */

public class BST {
    private Node root;

    private class Node{
        private int key;
        private Node left_child;
        private Node right_child;
        private Node parent;
        Node(int key){
            this.key = key;
        }
    }

    public void insert(int key){
        if (root == null) {
            root = new Node(key);
            return;
        }
        if(this.search(key) != null){
            System.out.println(key + " is already in the tree");
            return;
        }
        Node newNode = new Node(key);	// assume the data is same as key

        //////////////////////////////////// todo
        Node searchNode = root;
        while (searchNode.key != key){
            if (searchNode.key > key){
                if (searchNode.left_child == null) {
                    searchNode.left_child = newNode;
                    searchNode.left_child.parent = searchNode;
                    break;
                }
                searchNode = searchNode.left_child;
            } else {
                if (searchNode.right_child == null) {
                    searchNode.right_child = newNode;
                    searchNode.right_child.parent = searchNode;
                    break;
                }
                searchNode = searchNode.right_child;
            }
        }
        ////////////////////////////////////

    }
    public void delete(int key){
        //////////////////////////////////// todo
        Node searchNode = root;
        Node chgNode = null;

        while (searchNode != null){
            if (searchNode.key > key){
                searchNode = searchNode.left_child;
            } else if (searchNode.key < key) {
                searchNode = searchNode.right_child;
            } else {
                chgNode = searchNode;
                searchNode = searchNode.left_child;
                break;
            }
        }

        if(chgNode.left_child == null && chgNode.right_child == null){
            if (chgNode.parent.key > key)
                chgNode.parent.left_child = null;
            else
                chgNode.parent.right_child = null;
            return;
        }

        while (searchNode != null){
            if (searchNode.left_child == null && searchNode.right_child == null)
                break;
            if (searchNode.key > key){
                searchNode = searchNode.left_child;
            } else if (searchNode.key < key) {
                searchNode = searchNode.right_child;
                if (searchNode.right_child == null)
                    break;
            } else {
                chgNode = searchNode;
                searchNode = searchNode.left_child;
            }
        }

        if (searchNode.left_child != null)
            searchNode.parent.right_child = searchNode.left_child;
        else if (searchNode.parent.left_child == searchNode)
            searchNode.parent.left_child = null;
        else
            searchNode.parent.right_child = null;

        searchNode.left_child = chgNode.left_child;
        searchNode.right_child = chgNode.right_child;

        if (chgNode == root) {
            searchNode.parent = null;
            root = searchNode;
        } else {
            searchNode.parent = chgNode.parent;
        }
        ////////////////////////////////////
    }

    public Node search(int key){
        ///////////////////////////
        if (root == null)
            return root;
        Node searchNode = root;
        while (searchNode != null){
            if (searchNode.key > key){
                searchNode = searchNode.left_child;
            } else if (searchNode.key < key) {
                searchNode = searchNode.right_child;
            } else {
                return searchNode;
            }
        }

        return null;
        ///////////////////////////

    }

    public void printPreorder(Node node) {
        System.out.printf("%d ", node.key);
        if (node.left_child != null)
            printPreorder(node.left_child);
        if (node.right_child != null)
            printPreorder(node.right_child);
    }
    public void printInorder(Node node) {
        if (node.left_child != null)
            printInorder(node.left_child);
        System.out.printf("%d ", node.key);
        if (node.right_child != null)
            printInorder(node.right_child);
    }
    public void printPostorder(Node node) {
        if (node.left_child != null)
            printPostorder(node.left_child);
        if (node.right_child != null)
            printPostorder(node.right_child);
        System.out.printf("%d ", node.key);
    }
    public Node getRoot(){
        return root;
    }
}

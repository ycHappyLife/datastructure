package com.yc.study.ds.bst;

/**
 * @author ycrag
 */
public class BST<E extends Comparable<E>> {

    private class Node {
        E e;
        Node left, right;
        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;

    private int size;

    public BST() {
        this.root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        if (root == null) {
            root = new Node(e);
            size++;
        } else {
            add(root, e);
        }
    }

    private void add (Node node, E e) {
        if (node.e.equals(e)) {
            return;
        }
        if (node.e.compareTo(e) < 0 && node.left == null) {
            node.left = new Node(e);
            return;
        }else if (node.e.compareTo(e) > 0 && node.right == null) {
            node.right = new Node(e);
            return;
        }
        if (node.e.compareTo(e) < 0) {
            add(node.left, e);
        } else {
            add(node.right, e);
        }
    }

    private Node addOptimized(Node node, E e) {
        if (node == null) {
            node = new Node(e);
            return node;
        }
        if(e.compareTo(node.e) < 0) {
            node.left = addOptimized(node.left, e);
        }else if(e.compareTo(node.e) > 0) {
            node.right = addOptimized(node.right, e);
        }
        return node;
    }
}

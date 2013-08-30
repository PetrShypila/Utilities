package com.petrez.data.structures;


import com.petrez.data.wrappers.Node;

public class TreeSymbolTable<Key extends Comparable<Key>, Value> implements SymbolTable<Key, Value> {
    private Node<Key, Value> treeRoot;

    public  TreeSymbolTable() {
        this.treeRoot = null;
    }

    public  TreeSymbolTable(Node rootNode) {
        this.treeRoot = rootNode;
    }

    @Override
    public  Value  min() {
        return min(treeRoot).getValue();
    }

    private Node<Key, Value> min(Node<Key, Value> root) {
        if(root.getLeft() == null) return root;
        return min(root.getLeft());
    }

    @Override
    public  Value  max() {
        return max(treeRoot).getValue();
    }

    private Node<Key, Value> max(Node<Key, Value> root) {
        if(root.getRight() == null) return root;
        return max(root.getRight());
    }

    @Override
    public  Value  get(Key key) {
        if(key == null)
            throw new NullPointerException("Key can't be NULL");

        return get(treeRoot, key);
    }

    private Value  get(Node<Key, Value> root, Key key) {
        if(root == null) return null;

        int comparing = root.KEY.compareTo(key);

        if     (comparing > 0) return get(root.getLeft(), key);
        else if(comparing < 0) return get(root.getRight(), key);

        return root.getValue();
    }

    @Override
    public  void   add(Key key, Value value) {
        treeRoot = add(treeRoot, key, value);
    }

    @Override
    public  void   add(Node<Key, Value> node) {
        treeRoot = add(treeRoot, node.KEY, node.getValue());
    }

    @Override
    public  void   add(Node<Key, Value>[] nodes) {
        for(Node<Key, Value> node: nodes)
            treeRoot = add(treeRoot, node.KEY, node.getValue());
    }

    private Node   add(Node root, Key key, Value value) {
        if(key == null || value == null)
            throw new NullPointerException("Key or value can't be NULL");
        if(root == null) return new Node(key, value);

        int comparing = root.KEY.compareTo(key);

        if     (comparing > 0) root.setLeft (add(root.getLeft(),  key, value));
        else if(comparing < 0) root.setRight(add(root.getRight(), key, value));
        else                   root.setValue(value);

        return root;
    }

    @Override
    public  void   deleteMin() {
        treeRoot = deleteMin(treeRoot);
    }

    private Node   deleteMin(Node<Key, Value> root) {
        if(root == null)
            throw new NullPointerException("Root node can't be NULL");

        if(root.getLeft() == null) return root.getRight();
        root.setLeft(deleteMin(root.getLeft()));
        return root;
    }

    @Override
    public  void   deleteMax() {
        treeRoot = deleteMax(treeRoot);
    }

    private Node   deleteMax(Node<Key, Value> root) {
        if(root == null)
            throw new NullPointerException("Root node can't be NULL");

        if(root.getRight() == null) return root.getRight();
        root.setRight(deleteMax(root.getRight()));
        return root;
    }

    @Override
    public  void   delete(Key key) {
        treeRoot = delete(treeRoot, key);
    }

    private Node   delete(Node root, Key key) {
        if(root == key)
            throw new NullPointerException("Key can't be NULL");

        int comparing = root.KEY.compareTo(key);

        if(comparing > 0)      root.setLeft(delete(root.getLeft(), key));
        else if(comparing < 0) root.setRight(delete(root.getRight(), key));
        else {
            if(root.getRight() == null) return root.getLeft();
            if(root.getLeft()  == null) return root.getRight();

            Node temp = root;

            root = min(temp.getRight());
            root.setRight(temp.getRight());
            root.setLeft(temp.getLeft());
        }
        return root;
    }

    @Override
    public boolean isEmpty() {
        return treeRoot == null;
    }
}
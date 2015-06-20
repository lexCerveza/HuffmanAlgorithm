package com.lexcerveza;

/**
 * Created by Alex on 20.06.2015.
 */
public class Node {

    public int count;
    public Node left;
    public Node right;

    public Node(char c, Node left, Node right) {
        this.count = c;
        this.left = left;
        this.right = right;
    }
}

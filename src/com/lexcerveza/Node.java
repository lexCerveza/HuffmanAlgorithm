package com.lexcerveza;

/**
 * Created by Alex on 20.06.2015.
 */
public class Node {

    public int frequency;
    public char c;
    public Node left;
    public Node right;

    public Node(char c, int frequency) {
        this.frequency = frequency;
        this.c = c;
        this.left = null;
        this.right = null;
    }

    public Node(Node left, Node right){
        this.c = '\u0000';
        this.frequency = left.frequency + right.frequency;
        this.left = left;
        this.right = right;
    }
}

package com.lexcerveza;

import java.util.*;

/**
 * Created by Alex on 20.06.2015.
 */
public class HuffmanEncodeDecode {

    /**
     * Table character -> code in Huffmann tree
     */
    private static HashMap<Character, String> table;

    /**
     * Huffmann tree node code
     */
    private static StringBuilder code;

    /**
     * Recursive function to find all roots to Huffmann tree nodes with
     * characters
     * @param root - root
     * @return table
     */
    private static void generateTable(Node root){
        if(root.left != null){
            code.append("0");
            generateTable(root.left);
        }
        if(root.right != null){
            code.append("1");
            generateTable(root.right);
        }
        if(root.right == root.left){
            table.put(root.c, code.toString());
            code.deleteCharAt(code.length() - 1);
        }
    }

    public static String encode(String sourceString){
        // First of all, check all occurrences of each character
        // in string
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < sourceString.length(); i++){
            char targetChar = sourceString.charAt(i);

            // I did it tricky. Googling on stackoverflow.com is very useful sometimes
            int count = sourceString.length() - sourceString.replace(String.valueOf(targetChar), "").length();
            map.put(targetChar, count);
        }

        // Secondly, build a tree of nodes and sort it
        // I checked open-source implementation (http://rosettacode.org/wiki/Huffman_coding#Java)
        // and began using PriorityQueue. Using Comparator object, it sorts queue
        // in ascending order
        Comparator<Node> comparator = (node1, node2) -> node1.frequency - node2.frequency;
        PriorityQueue<Node> queue = new PriorityQueue<>(comparator);
        for (Map.Entry<Character, Integer> entry : map.entrySet()){
            queue.offer(new Node(entry.getKey(), entry.getValue()));
        }

        while(queue.size() != 1){
            Node node1 = queue.poll();
            Node node2 = queue.poll();

            queue.offer(new Node(node1, node2));
        }

        // Third, build a table of codes
        table = new HashMap<>();
        code = new StringBuilder();
        generateTable(queue.poll());

        // At last, generate the encoded message
        StringBuilder encodedMessage = new StringBuilder();
        for (int i = 0; i < sourceString.length(); i++){
            encodedMessage.append(table.get(sourceString.charAt(i)));
        }

        return encodedMessage.toString();
    }
}

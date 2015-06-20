package com.lexcerveza;

import java.util.*;

/**
 * Created by Alex on 20.06.2015.
 */
public class HuffmanEncodeDecode {

    public static void encode(String sourceString){
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
        // First implementation used LinkedList and it worked wrong. Node class
        // began using Comparable interface and instead of using LinkedList, I checked
        // open-source implementation (http://rosettacode.org/wiki/Huffman_coding#Java)
        // and began using PriorityQueue.
        // Don't know, how it worked fine with PriorityQueue, honest)
        // It's 11 pm) I need some goddamn coffee
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


        // Debug thing.
        // int i = 1;
    }
}

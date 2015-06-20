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
        List<Node> nodes = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()){
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }

        Comparator<Node> nodeComparator = (node1, node2) -> node1.count - node2.count;
        while(nodes.size() != 1) {
            nodes.sort(nodeComparator);
            Node left = nodes.get(0);
            nodes.remove(left);
            Node right = nodes.get(0);
            nodes.remove(right);

            Node parent = new Node(left, right);
            nodes.add(parent);
        }

        // Debug thing.
        int i = 1;
    }
}

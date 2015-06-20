package com.lexcerveza;

import com.sun.deploy.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

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
    }
}

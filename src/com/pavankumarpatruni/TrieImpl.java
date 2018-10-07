package com.pavankumarpatruni;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TrieNode {
	private int count = 0;
	private Map<String, TrieNode> ALPHABET_MAP = new HashMap<>();
	
    private TrieNode getNode(char character) {
    	return ALPHABET_MAP.get(character + "");
    }
    
    private void setNode(char character, TrieNode node) {
    	if (node.count == 1) {
    		ALPHABET_MAP.put(character + "", node);
    	}    	
    }
    
    void add(String value) {
        add(value, 0);
    }
    
    private void add(String value, int index) {
        if (value.length() != index) {
            char character = value.charAt(index);
            TrieNode node = getNode(character);
            if (node == null) {
                node = new TrieNode();
            }
            node.count++;
            setNode(character, node);          
            
            node.add(value, index+1);
        }
    }
    
    int find(String value) {
        if (value.length() == 0) return 0;
        return find(value, 0);
    }
    
    private int find(String value, int index) {
        char character = value.charAt(index);
        TrieNode node = getNode(character);
        if (node == null) {
            return 0;
        } else {
        	if (value.length() == index+1) {
 	           return node.count;
            }
        }
        return node.find(value, index+1);
    }   
   
}

public class TrieImpl {

    private static int[] contacts(String[][] queries) {
        List<Integer> list = new ArrayList<>();
        TrieNode node = new TrieNode();

        for (String[] query1 : queries) {
            String query = query1[0];
            String value = query1[1];

            if (query.equalsIgnoreCase("add")) {
                node.add(value);
            } else if (query.equalsIgnoreCase("find")) {
                list.add(node.find(value));
            }
        }
        
        int[] results = new int[list.size()];
        
        for (int index = 0; index < list.size(); index++) {
            results[index] = list.get(index);
        }
        
        return results;
    }

    public static void main(String[] args) {
        String[][] queries = {
        		{ "add", "s"}
        		, { "add", "ss"}
        		, { "add", "sss"}
        		, { "add", "ssss"}
        		, { "add", "sssss"}
        		, { "find", "s"}
        		, { "find", "ss"}
        		, { "find", "sss"}
        		, { "find", "ssss"}
        		, { "find", "sssss"}
        		, { "find", "ssssss"}
        };

        int[] result = contacts(queries);
        for (int aResult : result) {
            System.out.println(aResult);
        }
    }
}

package org.blbulyandavbulyan.jseminars.seminar5.classwork;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Task2 {
    public static boolean isCorrectBraces(String s, Map<Character, Character> bracers){
        Deque<Character> stack = new ArrayDeque<>();
        for(char symbol : s.toCharArray()){
            if(bracers.containsKey(symbol)) stack.push(symbol);
            else if(bracers.containsValue(symbol) && !stack.isEmpty()){
                if(!bracers.get(stack.pop()).equals(symbol))return false;
            }
            else return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        var braces = new HashMap<Character, Character>();
        braces.put('(', ')');
        braces.put('[', ']');
        System.out.println(isCorrectBraces("[[[", braces));
    }
}

package org.blbulyandavbulyan.jseminars.seminar1.classwork;

import java.util.Arrays;

public class FindPrefix {
    public static void main(String[] args) {
        String[] strs = {"дома", "довдваомаовой", "додомаааами"};
        int prefix = findPrefix(strs);
        if(prefix != -1) System.out.println("Префикс " + strs[0].substring(0, prefix));
        else System.out.println("Нет префикса");
    }
    public static int findPrefix(String[] strs){
        String[] lStrs = Arrays.stream(strs).map(s->s.toLowerCase()).toArray(String[]::new);
        String first = lStrs[0];
        int result = -1;
        for(int prefixLength = 1;  prefixLength < first.length(); prefixLength++){
            String prefix = first.substring(0, prefixLength);
            boolean match = true;
            for(int i = 1; i < lStrs.length; i++){
                String checkingStr = lStrs[i];
                if(!checkingStr.startsWith(prefix)){
                    match = false;
                    break;
                }
            }
            if(match){
                result = prefixLength;
            }
            else break;
        }
        return result;
    }
}

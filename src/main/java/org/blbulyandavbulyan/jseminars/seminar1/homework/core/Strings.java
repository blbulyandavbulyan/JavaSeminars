package org.blbulyandavbulyan.jseminars.seminar1.homework.core;

public class Strings {
    /**
     * Данный метод переставляет слова во фразе в обратном порядке
     * @param phrase фраза, в которой нужно переставить слова в обратном порядке
     * @return строку, содержащую слова в обратном порядке
     * */
    public static String reverseSentence(String phrase){
        //words содержит слова, с гарантированным отсутсвием пробелов по бокам
        String[] words = java.util.Arrays.stream(phrase.split(" ")).map(String::trim).toArray(String[]::new);
        StringBuilder reverseSentenceBuilder = new StringBuilder();
        for(int i = words.length - 1; i >= 0; i--) {
            reverseSentenceBuilder.append(words[i]);
            if(i != 0)reverseSentenceBuilder.append(" ");
        }

        return reverseSentenceBuilder.toString();
    }
}

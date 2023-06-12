package org.blbulyandavbulyan.jseminars.seminar2.classwork;

/**
 * Данный класс предоставляет два метода для простого сжатия и разжатия данных
 */
public class SimpleArchiver {
    /**
     * Превращает строку вида aaaffaa в строку a3f2a2
     * @param s строка для преобразования
     * @return преобразованную строку
     */
    public static String compress(String s){
        // FIXME: 09.06.2023 исправить метол
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        sb.append(chars[0]);
        int count = 1;
        char lastAddedChar = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if(lastAddedChar == chars[i]) count++;
            else {
                sb.append(count);
                count = 1;
                sb.append(chars[i]);
                lastAddedChar = chars[i];
            }
        }
        sb.append(count);
        return sb.toString();
    }

    /**
     * Данный метод обратный к {@link SimpleArchiver#compress(String)}
     * Превращает строку вида f2d3c4 в ffdddcccc
     * @param compressed строка, преобразованная методом compress
     * @return исходную строку, поданную на вход compress
     */
    public static String decompress(String compressed){
        StringBuilder result = new StringBuilder();
        int currentIndexInString = compressed.length() - 1;
        int currentCount = 0;
        while (currentIndexInString >= 0){
            int currentPower = 0;
            currentCount = 0;
            for(char currentChar = compressed.charAt(currentIndexInString); Character.isDigit(currentChar) && currentIndexInString >= 1; currentChar=compressed.charAt(--currentIndexInString)) {
                int digit = currentChar - '0';
                currentCount += digit * Math.pow(10, currentPower++);
            }
            if(!Character.isDigit(compressed.charAt(currentIndexInString)))
                currentIndexInString--;
            result.append(String.valueOf(compressed.charAt(currentIndexInString+1)).repeat(Math.max(0, currentCount)));
        }
        return result.reverse().toString();
    }
}

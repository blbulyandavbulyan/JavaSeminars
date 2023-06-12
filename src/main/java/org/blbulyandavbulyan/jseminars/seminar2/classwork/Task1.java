package org.blbulyandavbulyan.jseminars.seminar2.classwork;


//📌 Дано четное число N (>0) и символы c1 и c2.
//📌 Написать метод, который вернет строку длины N, которая
//состоит из чередующихся символов c1 и c2, начиная с c1.
public class Task1 {
    public static void main(String[] args) {
        char c1 = 'c', c2 = 'b';
        System.out.println(generateString(12, c1, c2));
    }
    public static String generateString(final int N, final char c1, final char c2){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < N/2; i++) {
            result.append(c1);
            result.append(c2);
        }
        if(N % 2 != 0){
            result.append(c1);
        }
        return result.toString();
    }
}

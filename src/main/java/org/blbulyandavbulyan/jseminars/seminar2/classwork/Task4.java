package org.blbulyandavbulyan.jseminars.seminar2.classwork;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

//📌 Напишите метод, который составит строку, состоящую из 100
//повторений слова TEST и метод, который запишет эту строку в
//простой текстовый файл, обработайте исключения.
public class Task4 {
    public static void main(String[] args) throws IOException {
        writeTestToFile(100, "output.txt");

    }
    public static void writeTestToFile(int n, String fileName) throws IOException {
        try(PrintWriter pw = new PrintWriter(new FileWriter(fileName))){
            pw.println(generateString("TEST\n", n));
        }
    }
    public static String generateString(String s, int repeatCount){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < repeatCount; i++) {
            sb.append(s);
        }
        return sb.toString();
    }
}

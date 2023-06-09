package org.blbulyandavbulyan.jseminars.seminar1.homework.tasks;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

//Задание №9 (доп)
//Записать в файл следующие данные:
//Name Surname Age
//Kate Smith 20
//Paul Green 25
//Mike Black 23
public class Task9 {
    public static void main(String[] args) throws IOException {
        try(PrintWriter printWriter = new PrintWriter(new FileWriter("tasktext.txt", StandardCharsets.UTF_8))){
            printWriter.println("Name Surname Age");
            printWriter.println("Kate Smith 20");
            printWriter.println("Paul Green 25");
            printWriter.println("Mike Black 23");
        }
    }
}

package org.blbulyandavbulyan.jseminars.seminar2.classwork;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

//📌 Напишите метод, который вернет содержимое текущей папки в виде
//массива строк.
//📌 Напишите метод, который запишет массив, возвращенный предыдущим
//методом в файл.
//📌 Обработайте ошибки с помощью try-catch конструкции. В случае
//возникновения исключения, оно должно записаться в лог-файл.
public class Task5 {
    // TODO: 10.06.2023 Сделать эту задачу
    public static void main(String[] args) throws IOException {
        var content = getContentFromCurrentDirectory();
        writeStringsToFile(content, "output.txt");
        System.out.println(Arrays.toString(content));
    }
    public static String[] getContentFromCurrentDirectory(){
        return new File(".").list();
    }
    public static void writeStringsToFile(String[] strings, String fileName) throws IOException {
        try(PrintWriter pw = new PrintWriter(fileName, StandardCharsets.UTF_8)){
            for (var str: strings){
                pw.println(str);
            }
        }
        catch (IOException ioException){
            try(PrintWriter pw = new PrintWriter("log.txt", StandardCharsets.UTF_8)){
                ioException.printStackTrace(pw);
            }
            catch (IOException logIoException){
                ioException.addSuppressed(logIoException);
                throw ioException;
            }
        }
    }
}

package org.blbulyandavbulyan.jseminars.seminar2.classwork;


import static org.blbulyandavbulyan.jseminars.seminar2.classwork.SimpleArchiver.compress;
import static org.blbulyandavbulyan.jseminars.seminar2.classwork.SimpleArchiver.decompress;

public class Task2 {
    public static void main(String[] args) {
        System.out.println(decompress(compress("affffddaffa")));
        System.out.println(compress("affffddaffa"));
    }

}

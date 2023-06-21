package org.blbulyandavbulyan.jseminars.seminar5.classwork;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Task1FromTeacher {

        //Integer[] intValue,String[] values
        public static HashMap<Integer,String> fill(){//String[] values
            HashMap<Integer,String> outMap = new HashMap<>();
            outMap.put(123456, "Иванов");
            outMap.put(321456, "Васильев");
            outMap.put(234561, "Петров");
            outMap.put(234432, "Иванов");
            outMap.put(654321, "Петров");
            outMap.put(345678, "Иванов");
            return outMap ;
        }

        public static void printHashMap(HashMap<Integer,String> outMap, String searchValue){

            for(Map.Entry<Integer,String> item: outMap.entrySet())
            {
                if(Objects.equals(item.getValue(), searchValue))
                {
                    System.out.println(item.getValue()+" - "+item.getKey());
                }
            }
        }


    public static void main(String[] args) throws Exception {
        HashMap<Integer,String> map = fill();
        Scanner sc = new Scanner(System.in);
        String searchString = sc.nextLine();
        printHashMap(map,searchString);
        String test = "aaa#b#";
        System.out.println(test.replace("#", "\b"));
    }
}

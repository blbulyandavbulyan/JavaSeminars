package org.blbulyandavbulyan.jseminars.seminar6.homework.laptop;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class LaptopSearchingParamsReader {
    private final static Map<String, String> displayableNameToParameter = new LinkedHashMap<>();
    static {
        displayableNameToParameter.put("Производитель: ", "vendor");
        displayableNameToParameter.put("Модель: ", "model");
        displayableNameToParameter.put("Операционная система: ", "os");
        displayableNameToParameter.put("Цвет: ", "color");
        displayableNameToParameter.put("Минимальный объём оперативной памяти: ", "minRAM");
        displayableNameToParameter.put("Минимальный объём жёсткого диска: ", "minHDD");
    }
    public static Map<String, String> getParametersMapFromKeyboard(){
        Map<String, String> result = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        for(var entry : displayableNameToParameter.entrySet()){
            System.out.print(entry.getKey());
            String searchParameter = scanner.nextLine();
            if(!searchParameter.isBlank())result.put(entry.getValue(), searchParameter);
        }
        return result;
    }
}

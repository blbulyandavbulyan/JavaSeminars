package org.blbulyandavbulyan.jseminars.seminar6.homework.laptop;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Задача данного класса - удобное получение параметров поиска для метода find в LaptopStore
 */
public class LaptopSearchingParamsReader {
    /**
     * Данная Map нужна, чтобы связать строку подсказку, которая будет отображаться на экране с параметрами для функции поиска
     */
    private final static Map<String, String> displayableNameToParameter = new LinkedHashMap<>();
    static {//статический блок инициализации, чтобы наполнить мапу значениями
        displayableNameToParameter.put("Производитель: ", "vendor");
        displayableNameToParameter.put("Модель: ", "model");
        displayableNameToParameter.put("Операционная система: ", "os");
        displayableNameToParameter.put("Цвет: ", "color");
        displayableNameToParameter.put("Минимальный объём оперативной памяти: ", "minRAM");
        displayableNameToParameter.put("Минимальный объём жёсткого диска: ", "minHDD");
    }

    /**
     * Данный метод предназначен для получения параметров поиска с клавиатуры для функции find в классе LaptopStore
     * @return искомые параметры поиска
     */
    public static Map<String, String> getParametersMapFromKeyboard(){
        Map<String, String> result = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        for(var entry : displayableNameToParameter.entrySet()){
            //фокус в том, что я беру ключ отображаю его на экране, этот ключ - подсказка, что нужно вводить
            System.out.print(entry.getKey());//выводим подсказку на экран
            String searchParameter = scanner.nextLine();//запрашиваем строку у сканера
            if(!searchParameter.isBlank())//если строка не пуста(а нам это нужно, чтобы работали значения по умолчанию, если она пуста)
                result.put(entry.getValue(), searchParameter);//то добавляем её в результат(здесь entry.value - на самом деле будет ключом для result)
        }
        return result;
    }
}

package org.blbulyandavbulyan.jseminars.seminar2.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JSONFunctions {
    /**
     * Конвертирует строку в json формате в hashMap
     * ВЛОЖЕННОСТЬ НЕ ПОДДЕРЖИВАЕТСЯ
     * @param jsonObject строка в json формате
     * @return Map в котором ключ - имя свойства, а значение - само свойство
     * */
    public static Map<String, Object> convertJSONObjectToMap(String jsonObject){
        Map<String, Object> result = new HashMap<>();
        String regex = "\"([\\wа-яА-Я]+)\":(\"[\\wа-яА-Я]+\"|\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(jsonObject);
        while (matcher.find()){
            String key = matcher.group(1);
            String valueOfKey = matcher.group(2);
            Object objValue;
            //наш valueOfKey - строка
            if(valueOfKey.contains("\"")){
                objValue = valueOfKey.replaceAll("\"", "");
                if(objValue.equals("null"))objValue = null;
            }
            //наш value - число
            else{
                try{
                    objValue = Integer.valueOf(valueOfKey);
                }
                catch (NumberFormatException e){
                    throw new IllegalArgumentException("Неверная json строка", e);
                }
            }
            if(objValue != null){
                if(!result.containsKey(key))result.put(key, objValue);
                else throw new IllegalArgumentException("Ваша json строка содержит несколько значений под одним и тем же ключом");
            }
        }
        return result;
    }
    public static Map<String, Object>[] convertJSONArrayOfObjectsToObjectArray(String jsonArray){
        ArrayList<String> objectStrings = new ArrayList<>();
        Matcher matcher = Pattern.compile("(\\{([^{}]+)\\}),? *").matcher(jsonArray);
        while (matcher.find()) {
            objectStrings.add(matcher.group(1));
        }
        return objectStrings.stream().map(JSONFunctions::convertJSONObjectToMap).toArray(Map[]::new);
    }

}

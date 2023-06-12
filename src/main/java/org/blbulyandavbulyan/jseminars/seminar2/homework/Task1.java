package org.blbulyandavbulyan.jseminars.seminar2.homework;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//1) Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
//Если значение null, то параметр не должен попадать в запрос.
public class Task1 {
    public static void main(String[] args) {
        var result = convertJSONStringToMap("{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}");
        System.out.println(result);
        System.out.println(generateWherePartEqualsAll(result, "AND"));
    }
    /**
     * Конвертирует строку в json формате в hashMap
     * ВЛОЖЕННОСТЬ НЕ ПОДДЕРЖИВАЕТСЯ
     * @param jsonString строка в json формате
     * @return Map в котором ключ - имя свойства, а значение - само свойство
     * */
    public static Map<String, Object> convertJSONStringToMap(String jsonString){
        Map<String, Object> result = new HashMap<>();
        String regex = "\"(\\w+)\":(\"\\w+\"|\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(jsonString);
        while (matcher.find()){
            String key = matcher.group(1);
            String valueOfKey = matcher.group(2);
            Object objValue = null;
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

    /**
     * Генерирует строку для sql запроса с where где имя_столбца = значению
     * @param params map, где ключ - имя столбца в таблице, а значение - параметр для сравнения
     * @param logicalOperator бинарный логический оператор, который будет разделять фрагменты имя столбца = значению
     * @return строку вида имя_стобца1 = значение1 $logicalOperator имя_стобца2 = значение2 ...
     */
    public static String generateWherePartEqualsAll(Map<String, Object> params, String logicalOperator){
        StringBuilder sb = new StringBuilder();
        var entryIterator = params.entrySet().iterator();
        while (entryIterator.hasNext()){
            var entry = entryIterator.next();
            var key = entry.getKey();
            var value = entry.getValue();
            sb.append(key);
            sb.append("=");
            if(value instanceof Number) sb.append(value);
            else if(value instanceof String){
                sb.append("'");
                sb.append(value);
                sb.append("'");
            }
            else throw new IllegalArgumentException("В входных параметрах в качестве значения обнаружен не поддерживаемый тип!");
            if(entryIterator.hasNext()) {
                sb.append(" ");
                sb.append(logicalOperator);
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}

package org.blbulyandavbulyan.jseminars.seminar2.homework;

import java.util.Map;

import static org.blbulyandavbulyan.jseminars.seminar2.homework.JSONFunctions.convertJSONObjectToMap;

//1) Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
//Если значение null, то параметр не должен попадать в запрос.
public class Task1 {
    public static void main(String[] args) {
        var result = convertJSONObjectToMap("{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}");
        System.out.println(result);
        System.out.println(generateWherePartEqualsAll(result, "AND"));
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

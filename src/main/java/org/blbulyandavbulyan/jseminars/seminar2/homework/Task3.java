package org.blbulyandavbulyan.jseminars.seminar2.homework;

import java.util.Map;

import static org.blbulyandavbulyan.jseminars.seminar2.homework.JSONFunctions.convertJSONArrayOfObjectsToObjectArray;

public class Task3 {
    public static void main(String[] args) {
        String jsonString = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"},{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"},{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";
        Map<String, Object>[] objMaps = convertJSONArrayOfObjectsToObjectArray(jsonString);
        StringBuilder outputString = new StringBuilder();
        for(var objMap : objMaps){
            outputString.append("Студент ");
            outputString.append(objMap.get("фамилия"));
            outputString.append(" получил оценку ");
            outputString.append(objMap.get("оценка"));
            outputString.append(" по предмету ");
            outputString.append(objMap.get("предмет"));
            System.out.println(outputString);
            outputString.setLength(0);
        }
    }
}

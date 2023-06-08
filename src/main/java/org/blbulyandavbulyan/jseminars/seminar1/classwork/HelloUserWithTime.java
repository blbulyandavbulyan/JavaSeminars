package org.blbulyandavbulyan.jseminars.seminar1.classwork;

import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

//В консоли запросить имя пользователя. В зависимости от текущего времени, вывести приветствие вида
//        "Доброе утро, <Имя>!", если время от 05:00 до 11:59
//        "Добрый день, <Имя>!", если время от 12:00 до 17:59;
//        "Добрый вечер, <Имя>!", если время от 18:00 до 22:59;
//        "Доброй ночи, <Имя>!", если время от 23:00 до 4:59
public class HelloUserWithTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


    }
    public static String getTimeString(String userName){
        Date date = new Date();
        LocalTime localTime = LocalTime.now();
        int hour = localTime.getHour();
        int minutes = localTime.getMinute();
        if(hour >= 5 && hour < 12){
            return "Доброе утро, " + userName;
        }
        else if(hour >= 12 && hour < 18){
            return "Добрый день," + userName;
        }
        else if(hour >= 18 && hour < 23){

        }
        else if((hour == 23 && minutes <= 59) || (hour > 0 && hour < 5)){
            return "Доброй ночи, " + userName;
        }
        throw new RuntimeException();
    }
}

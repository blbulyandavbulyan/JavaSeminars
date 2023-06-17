package org.blbulyandavbulyan.utils;

/**
 * Данный утилитный класс будет содержать всякие методы для удобной работы со временем
 */
public class Times {
    /**
     * Замеряет время, которое было потрачено на выполнение переданной задачи
     * @param r задача, которую нужно выполнить и замерить время её выполнения
     * @return количество миллисекунд, затраченных на выполнение задачи
     */
    public static long measureTime(Runnable r){
        long result = System.currentTimeMillis();
        r.run();
        result = System.currentTimeMillis() - result;
        return result;
    }
}

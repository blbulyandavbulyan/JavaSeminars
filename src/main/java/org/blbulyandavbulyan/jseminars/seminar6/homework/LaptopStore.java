package org.blbulyandavbulyan.jseminars.seminar6.homework;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 * Данный класс предоставляет некое подобие магазина ноутбуков
 * В нём можно искать ноутбуки
 */
public class LaptopStore {

    private Collection<Laptop> laptops = new ArrayList<>();

    /**
     * Создаёт экземпляр магазина с заданным набором ноутбуков
     * @param laptops набор ноутбуков, который будет в данном магазине
     */
    public LaptopStore(Collection<Laptop> laptops) {
        this.laptops.addAll(laptops);
    }

    /**
     * Ищет подходящие ноутбуки по заданным критериям
     * @param filteringParams Map содержащая параметры, в Map могут быть следующие ключи:
     *                        vendor - производитель(тип значения String)
     *                        model - модель(тип значения String)
     *                        os - наименование операционной системы(тип значения String)
     *                        color - цвет(тип значения String)
     *                        minRAM - минимальный объём памяти(тип значения Long)
     *                        minHDD - минимальный объём жёсткого диска(тип значения Long)
     * @return коллекцию, содержащую подходящие ноутбуки, или пустую коллекцию, если таковых не нашлось
     */
    public Collection<Laptop> find(Map<String, Object> filteringParams){
        String vendor = (String) filteringParams.getOrDefault("vendor", "");
        String model = (String)filteringParams.getOrDefault("model", "");
        String OSName = (String)filteringParams.getOrDefault("os", "");
        String color = (String)filteringParams.getOrDefault("color", "");
        long minimalRamSize = (Long) filteringParams.getOrDefault("minRAM", 0);
        long minimalHDDSize = (Long)filteringParams.getOrDefault("minHDD", 0);
        return laptops.stream().filter(laptop ->
                (vendor == null || vendor.isBlank() || laptop.getVendor().contains(vendor)) &&//проверка на производителя
                        (model == null || model.isBlank() || laptop.getModel().contains(model)) &&//проверка на модель
                        (OSName == null || OSName.isBlank() || laptop.getOSName().contains(OSName)) &&//проверка на ОС
                        (color == null || color.isBlank() || laptop.getColor().contains(color)) &&//проверка на цвет
                        (laptop.getRAMSize() >= minimalRamSize) && (laptop.getHDDSize() >= minimalHDDSize)//проверка на объём памяти и размер HDD
        ).toList();
    }
}

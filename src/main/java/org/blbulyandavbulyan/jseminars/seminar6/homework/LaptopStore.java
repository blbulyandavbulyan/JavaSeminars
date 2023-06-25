package org.blbulyandavbulyan.jseminars.seminar6.homework;


import java.util.Collection;
import java.util.stream.Collectors;

public class LaptopStore {
    private Collection<Laptop> laptops;

    public LaptopStore() {

    }

    /**
     * Ищет подходящие ноутбуки по заданным критериям
     * Строковые параметры могут быть null или пустыми, если их учитывать не нужно
     * @param vendor производитель
     * @param model модель
     * @param OSName наименование операционной системы
     * @param color цвет
     * @param minimalRamSize минимальный размер памяти
     * @param minimalHDDSize минимальный размер жёсткого диска
     * @return коллекцию, содержащую подходящие ноутбуки, или пустую коллекцию, если таковых не нашлось
     */
    public Collection<Laptop> find(String vendor, String model, String OSName, String color, long minimalRamSize, long minimalHDDSize) {
        return laptops.stream().filter(laptop ->
            (vendor == null || vendor.isBlank() || laptop.getVendor().contains(vendor)) &&//проверка на производителя
            (model == null || model.isBlank() || laptop.getModel().contains(model)) &&//проверка на модель
            (OSName == null || OSName.isBlank() || laptop.getOSName().contains(OSName)) &&//проверка на ОС
            (color == null || color.isBlank() || laptop.getColor().contains(color)) &&//проверка на цвет
            (laptop.getRAMSize() >= minimalRamSize) && (laptop.getHDDSize() >= minimalHDDSize)//проверка на объём памяти и размер HDD
        ).toList();
    }
}

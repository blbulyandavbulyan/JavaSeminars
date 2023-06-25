package org.blbulyandavbulyan.jseminars.seminar6.homework.laptop;

import java.util.Objects;

/**
 * Данный класс предоставляет описание ноутбука для моего почти магазина
 */
public class Laptop {//примечание: на самом деле, здесь лучше было бы использовать record, а не class, но мы же record не проходили, да и в условии было сказано про класс

    /**
     * Производитель
      */
    private final String vendor;
    /**
     * Модель
     */
    private final String model;
    /**
     * Объём ОЗУ(в байтах)
     */
    private final long RAMSize;
    /**
     * Объём HDD(в байтах)
     */
    private final long HDDSize;
    /**
     * Наименование операционной системы
     */
    private final String OSName;
    /**
     * Цвет в строковом представлении(словами)
     */
    private final String color;

    /**
     * Конструктор, создающий экземпляр ноутбука
     * @param vendor производитель
     * @param model модель
     * @param OSName наименование операционной системы
     * @param color цвет в строковом представлении
     * @param RAMSize объём оперативной памяти(в байтах)
     * @param HDDSize объём жёсткого диска(в байтах)
     */
    public Laptop(String vendor, String model, String OSName, String color, long RAMSize, long HDDSize) {
        this.vendor = vendor;
        this.model = model;
        this.RAMSize = RAMSize;
        this.HDDSize = HDDSize;
        this.OSName = OSName;
        this.color = color;
    }

    /**
     * @return объём ОЗУ в байтах
     */
    public long getRAMSize() {
        return RAMSize;
    }

    /**
     * @return объём жёсткого диска в байтах
     */
    public long getHDDSize() {
        return HDDSize;
    }

    /**
     * @return наименование операционной системы
     */
    public String getOSName() {
        return OSName;
    }

    /**
     * @return цвет
     */
    public String getColor() {
        return color;
    }

    /**
     * @return производитель ноутбука
     */
    public String getVendor() {
        return vendor;
    }

    /**
     * @return модель ноутбука
     */
    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return "{%s %s, RAM size: %d bytes, HDD size: %d bytes, OS family: %s, color: %s}"
                .formatted(getVendor(), getModel(), getRAMSize(), getHDDSize(), getOSName(), getColor());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;//проверка на самого себя
        if (o == null || getClass() != o.getClass()) return false;//проверка на null и проверка на несовпадение типов
        Laptop laptop = (Laptop) o;//у нас определённо o точно не null и типы совпадают, значит можем кастить
        //ну а дальше просто сравниваем все поля
        return RAMSize == laptop.RAMSize && HDDSize == laptop.HDDSize &&
                Objects.equals(vendor, laptop.vendor) && Objects.equals(model, laptop.model) &&
                Objects.equals(OSName, laptop.OSName) && Objects.equals(color, laptop.color);
    }

    @Override
    public int hashCode() {
        //используем стандартный метод для комбинирования хэша, нужно так же иметь в виду, что если equals возвращает true для двух объектов, то и хэшкод должен быть одинаковый
        return Objects.hash(vendor, model, RAMSize, HDDSize, OSName, color);
    }
}

package org.blbulyandavbulyan.jseminars.seminar6.homework;

import java.util.Objects;

public class Laptop {
//    private Long id;
    private final String vendor;
    private final String model;
    private final long RAMSize;
    private final long HDDSize;
    private final String OSName;
    private final String color;

    public Laptop(String vendor, String model, long RAMSize, long HDDSize, String OSName, String color) {
        this.vendor = vendor;
        this.model = model;
        this.RAMSize = RAMSize;
        this.HDDSize = HDDSize;
        this.OSName = OSName;
        this.color = color;
    }

    public long getRAMSize() {
        return RAMSize;
    }

    public long getHDDSize() {
        return HDDSize;
    }

    public String getOSName() {
        return OSName;
    }

    public String getColor() {
        return color;
    }

    public String getVendor() {
        return vendor;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return "%s %s, RAM size: %d bytes, HDD size: %d bytes, OS family: %s, color: %s"
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

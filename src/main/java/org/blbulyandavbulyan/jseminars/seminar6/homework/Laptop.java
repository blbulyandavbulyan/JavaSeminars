package org.blbulyandavbulyan.jseminars.seminar6.homework;

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
                .formatted(vendor, model, getRAMSize(), getHDDSize(), getOSName(), getColor());
    }
}

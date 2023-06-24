package org.blbulyandavbulyan.jseminars.seminar6.homework;

public class Laptop {
//    private Long id;
    private final long RAMSize;
    private final long HDDSize;
    private final String OSName;
    private final String color;

    public Laptop(long RAMSize, long HDDSize, String OSName, String color) {
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

}

package org.blbulyandavbulyan.jseminars.seminar6.homework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import static org.blbulyandavbulyan.jseminars.seminar6.homework.LaptopSearchingParamsReader.getParametersMapFromKeyboard;

public class Task2 {
    public static void main(String[] args) {
        LaptopStore laptopStore = createStore();
        Map<String, String> searchParameters = getParametersMapFromKeyboard();
        Collection<Laptop> foundLaptops = laptopStore.find(searchParameters);
        if(foundLaptops.isEmpty())
            System.out.println("По вашему запросу ничего не найдено!");
        else System.out.println(foundLaptops);
    }
    public static LaptopStore createStore(){
        Collection<Laptop> laptops = new ArrayList<>();
        Collections.addAll(
                laptops,
                new Laptop("Lenovo", "B558", "Windows 8", "black", 4096, 8000),
                new Laptop("Lenovo", "B559", "Windows 8", "black", 4096, 8000),
                new Laptop("Sony", "Vaio", "Windows 11", "blue", 16384, 500_000),
                new Laptop("Asus", "ROG", "Windows 10", "red-black", 8192, 100_000)
        );
        return new LaptopStore(laptops);
    }
}
